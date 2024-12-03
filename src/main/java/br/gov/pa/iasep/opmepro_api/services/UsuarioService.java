package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioAtualizacaoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioComFuncionalidadesDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Usuario;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.CredenciadoMapper;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.opmepro_api.repositories.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UserMapper userMapper;
    private final CredenciadoMapper credenciadoMapper;
    private final UsuarioValidacoesService usuarioValidacoesService;

    public UsuarioService(
            UsuarioRepository usuarioRepository, UsuarioValidacoesService usuarioValidacoesService,
            UserMapper userMapper, CredenciadoMapper credenciadoMapper
    ) {
        this.usuarioRepository = usuarioRepository;
        this.userMapper = userMapper;
        this.credenciadoMapper = credenciadoMapper;
        this.usuarioValidacoesService = usuarioValidacoesService;
    }

    public List<UsuarioDetalhadoDTO> getUsuarios(){
        return usuarioRepository.findAll()
                .stream()
                .map(userMapper::toUsuarioListasDTO)
                .toList();
    }

    public List<UsuarioComFuncionalidadesDTO> fetchUsuariosComFuncionalidades(){
        return usuarioRepository.findAll()
                .stream()
                .map(userMapper::toUsuarioAndFuncionalidadesDTO)
                .toList();
    }

    public List<UsuarioResumidoDTO> fetchUsuariosBasicos(){
        return usuarioRepository.findAll()
                .stream()
                .map(userMapper::toUsuarioDTO)
                .toList();
    }

    public CredenciadoResumidoDTO getCredenciadoDeUsuario(Integer id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));

        return credenciadoMapper.toResponseDTO(usuario.getCredenciado());
    }

    public ApiResponse atualizarUsuario(UsuarioAtualizacaoDTO updateDTO){
        Usuario usuario = usuarioRepository.findById(updateDTO.id())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        if(!usuario.getUsername().equals(updateDTO.username())){
            this.usuarioValidacoesService.checkForDuplicateUsername(updateDTO.username());
            usuario.setUsername(updateDTO.username());
        }

        if(!usuario.getCpf().equals(updateDTO.cpf())){
            this.usuarioValidacoesService.checkForDuplicateCpf(updateDTO.cpf());
            usuario.setCpf(updateDTO.cpf());
        }

        if(!usuario.getEmail().equals(updateDTO.email())){
            this.usuarioValidacoesService.checkForDuplicateEmail(updateDTO.email());
            usuario.setEmail(updateDTO.email());
        }

        if(!usuario.getCredenciado().getId().equals(updateDTO.credenciado().id())
                && !usuario.getCredenciado().getCnpj().equals(updateDTO.credenciado().cnpj())){
            usuario.setCredenciado(credenciadoMapper.toEntity(updateDTO.credenciado()));
        }

        if(updateDTO.password() != null){
            usuario.setPassword(new BCryptPasswordEncoder().encode(updateDTO.password()));
        }

        usuario.setId(updateDTO.id());
        usuario.setNome(updateDTO.nome());
        usuario.setTelefone(updateDTO.telefone());
        usuario.setSituacao(updateDTO.situacao());
        usuario.setPerfil(userMapper.toEntity(updateDTO.perfil()));

        usuarioRepository.save(usuario);

        return new ApiResponse("Dados atualizados com sucesso.", true);
    }

}
