package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioAtualizacaoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioComFuncionalidadesDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Usuario;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioHistorico;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.CredenciadoMapper;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.opmepro_api.repositories.UsuarioHistoricoRepository;
import br.gov.pa.iasep.opmepro_api.repositories.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioHistoricoRepository usuarioHistoricoRepository;
    private final UserMapper userMapper;
    private final CredenciadoMapper credenciadoMapper;
    private final ValidacoesService validacoesService;

    public UsuarioService(
            UsuarioRepository usuarioRepository, UsuarioHistoricoRepository usuarioHistoricoRepository,
            UserMapper userMapper, CredenciadoMapper credenciadoMapper, ValidacoesService validacoesService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioHistoricoRepository = usuarioHistoricoRepository;
        this.userMapper = userMapper;
        this.credenciadoMapper = credenciadoMapper;
        this.validacoesService = validacoesService;
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

        UsuarioHistorico usuarioHistorico = contruirHistoricoBackup(usuario, updateDTO);

        if(!usuario.getUsername().equals(updateDTO.username())){
            this.validacoesService.checkForDuplicateUsername(updateDTO.username());
            usuario.setUsername(updateDTO.username());
        }

        if(!usuario.getCpf().equals(updateDTO.cpf())){
            this.validacoesService.checkForDuplicateCpf(updateDTO.cpf());
            usuario.setCpf(updateDTO.cpf());
        }

        if(!usuario.getEmail().equals(updateDTO.email())){
            this.validacoesService.checkForDuplicateEmail(updateDTO.email());
            usuario.setEmail(updateDTO.email());
        }

        if(!usuario.getCredenciado().getId().equals(updateDTO.credenciado().id())
                && !usuario.getCredenciado().getCnpj().equals(updateDTO.credenciado().cnpj())){
            usuario.setCredenciado(credenciadoMapper.toEntity(updateDTO.credenciado()));
        }

        if(updateDTO.password() != null){
            usuario.setPassword(new BCryptPasswordEncoder().encode(updateDTO.password()));
        }

        usuario.setNome(updateDTO.nome());
        usuario.setTelefone(updateDTO.telefone());
        usuario.setSituacao(updateDTO.situacao());
        usuario.setPerfil(userMapper.toEntity(updateDTO.perfil()));

        usuarioRepository.save(usuario);
        usuarioHistoricoRepository.save(usuarioHistorico);

        return new ApiResponse("Dados atualizados com sucesso.", true);
    }


    private UsuarioHistorico contruirHistoricoBackup(Usuario usuario, UsuarioAtualizacaoDTO updateDTO){

        UsuarioHistorico usuarioHistorico = new UsuarioHistorico();
        usuarioHistorico.setNome(usuario.getNome());
        usuarioHistorico.setCpf(usuario.getCpf());
        usuarioHistorico.setUsername(usuario.getUsername());
        usuarioHistorico.setPassword(usuario.getPassword());
        usuarioHistorico.setTelefone(usuario.getTelefone());
        usuarioHistorico.setEmail(usuario.getEmail());
        usuarioHistorico.setSituacao(usuario.getSituacao());
        usuarioHistorico.setDataAlteracao(LocalDateTime.now());
        usuarioHistorico.setUsuarioAlteracao(updateDTO.usuarioAlteracao());
        usuarioHistorico.setPerfil(usuario.getPerfil().getId());
        usuarioHistorico.setCredenciado(usuario.getCredenciado().getId());
        usuarioHistorico.setUsuario(usuario);

        return usuarioHistorico;
    }

}
