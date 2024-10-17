package br.gov.pa.iasep.copme_api.model.services;

import br.gov.pa.iasep.copme_api.exceptions.UnauthorizedException;
import br.gov.pa.iasep.copme_api.infra.security.TokenService;
import br.gov.pa.iasep.copme_api.model.entities.DTOs.LoginRequestDTO;
import br.gov.pa.iasep.copme_api.model.entities.DTOs.LoginResponseDTO;
import br.gov.pa.iasep.copme_api.model.entities.DTOs.RequestUserDTO;
import br.gov.pa.iasep.copme_api.model.entities.User;
import br.gov.pa.iasep.copme_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.copme_api.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final TokenService tokenService;

    public AuthenticationService (UserRepository userRepository, UserMapper userMapper, TokenService tokenService){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.tokenService = tokenService;
    }

    public String createAccountService(RequestUserDTO userDto){
        if(userRepository.findByUsername(userDto.username()) != null) throw new IllegalArgumentException("Já existe um usuário com o login informado");
        if(userRepository.findByCpf(userDto.cpf()) != null) throw new IllegalArgumentException("Já existe um usuário com o CPF informado");
        if(userRepository.findByEmail(userDto.email()) != null)  throw new IllegalArgumentException("Já existe um usuário com o e-mail informado");
        if(userRepository.findByRegistration(userDto.registration()) != null) throw new IllegalArgumentException("Já existe um usuário com a matrícula informada");

        String encryptedPassword = new BCryptPasswordEncoder().encode(userDto.password());
        User user = new User(
                userDto.fullName(),
                userDto.cpf(),
                userDto.registration(),
                userDto.email(),
                userDto.phone(),
                userDto.username(),
                encryptedPassword,
                userDto.situation(),
                userDto.role()
        );
        userRepository.save(user);

        return "Usuário cadastrado com sucesso!";
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
        var user = (User) userRepository.findByUsername(loginRequestDTO.username());

        if (user != null && new BCryptPasswordEncoder().matches(loginRequestDTO.password(), user.getPassword())) {
            var token = tokenService.generateToken(user);
            return new LoginResponseDTO(token);
        } else {
            throw new UnauthorizedException("Usuário ou senha inválido!");
        }
    }

}
