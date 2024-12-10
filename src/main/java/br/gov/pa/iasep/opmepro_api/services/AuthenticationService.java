package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.config.security.TokenService;
import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.InvalidArgumentException;
import br.gov.pa.iasep.opmepro_api.exceptions.UnauthorizedException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginRequestDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginResponseDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Usuario;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.opmepro_api.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final UsuarioRepository usuarioRepository;

    private final UserMapper userMapper;

    private final TokenService tokenService;

    private final HistoricoSessaoService historicoSessaoService;

    public AuthenticationService(UsuarioRepository usuarioRepository, UserMapper userMapper, TokenService tokenService, HistoricoSessaoService historicoSessaoService) {
        this.usuarioRepository = usuarioRepository;
        this.userMapper = userMapper;
        this.tokenService = tokenService;
        this.historicoSessaoService = historicoSessaoService;
    }

    public ApiResponse cadastrarUsuario(UsuarioCadastroDTO userDto){
        if(usuarioRepository.findByUsername(userDto.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
        if(usuarioRepository.findByCpf(userDto.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
        if(usuarioRepository.findByEmail(userDto.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");
        if(userDto.perfil().tipoUsuario().equals(true) && userDto.credenciado() == null) throw new InvalidArgumentException("É obrigatório selecionar a empresa credenciada correspondente ao usuário com perfil Credenciado.");

        String encryptedPassword = new BCryptPasswordEncoder().encode(userDto.password());

        Usuario regularUser = new Usuario(
                userDto.nome(),
                userDto.cpf(),
                userDto.username(),
                encryptedPassword,
                userDto.telefone(),
                userDto.email(),
                userDto.situacao(),
                !userDto.perfil().tipoUsuario() ? null : userMapper.toEntity(userDto).getCredenciado(),
                userMapper.toEntity(userDto.perfil()),
                userMapper.toEntity(userDto.situacaoUsuario())
        );

        usuarioRepository.save(regularUser);

        return new ApiResponse("Usuário cadastrado com sucesso!", true);
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO, HttpServletRequest request){
        var usuario = (Usuario) usuarioRepository.findByUsername(loginRequestDTO.username());

        if (usuario != null && new BCryptPasswordEncoder().matches(loginRequestDTO.password(), usuario.getPassword())) {

            if(!usuario.getSituacao()){
                throw new UnauthorizedException("Usuário não autorizado, a conta deste usuário está desativada!");
            }

            var token = tokenService.generateToken(usuario);
            this.historicoSessaoService.iniciarSessao(usuario, request.getRemoteAddr());

            return new LoginResponseDTO(token);
        } else {
            throw new UnauthorizedException("Usuário ou senha inválido!");
        }
    }

}
