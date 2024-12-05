package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.FeatureNotFoundException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.RequestUsuarioFuncionalidadeDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioFuncionalidadeResponseUsuarioDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Funcionalidade;
import br.gov.pa.iasep.opmepro_api.model.entities.Usuario;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioFuncionalidade;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioFuncionalidadeId;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.FuncionalidadeMapper;
import br.gov.pa.iasep.opmepro_api.repositories.FuncionalidadeRepository;
import br.gov.pa.iasep.opmepro_api.repositories.UsuarioFuncionalidadeRepository;
import br.gov.pa.iasep.opmepro_api.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioFuncionalidadeService {

    private final UsuarioFuncionalidadeRepository usuarioFuncionalidadeRepository;
    private final FuncionalidadeRepository funcionalidadeRepository;
    private final UsuarioRepository usuarioRepository;
    private final FuncionalidadeMapper usuarioFuncionalidadeMapper;

    public UsuarioFuncionalidadeService(
            UsuarioFuncionalidadeRepository usuarioFuncionalidadeRepository,
            FuncionalidadeRepository funcionalidadeRepository,
            UsuarioRepository usuarioRepository,
            FuncionalidadeMapper usuarioFuncionalidadeMapper
    )
    {
        this.usuarioFuncionalidadeRepository = usuarioFuncionalidadeRepository;
        this.funcionalidadeRepository = funcionalidadeRepository;
        this.usuarioRepository = usuarioRepository;
        this.usuarioFuncionalidadeMapper = usuarioFuncionalidadeMapper;
    }

    public List<UsuarioFuncionalidadeResponseUsuarioDTO> obterFuncionalidadesUsuario(Integer id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        List<UsuarioFuncionalidade> funcionalidades = usuarioFuncionalidadeRepository.findByUsuario(usuario)
                .orElse(null);

        return funcionalidades.stream()
                .map(usuarioFuncionalidadeMapper::toUsuarioFuncionalidadeResponseUsuarioDTO)
                .collect(Collectors.toList());
    }

    public ApiResponse atribuirFuncionalidade(List<RequestUsuarioFuncionalidadeDTO> usuarioFuncionalidade){
        for (RequestUsuarioFuncionalidadeDTO funcionalidadeRequest : usuarioFuncionalidade){

            Funcionalidade funcionalidade = funcionalidadeRepository.findById(funcionalidadeRequest.idFuncionalidade())
                    .orElseThrow(() -> new FeatureNotFoundException("Funcionalidade não encontrada!"));

            Usuario usuario = usuarioRepository.findById(funcionalidadeRequest.idUsuario())
                    .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

            UsuarioFuncionalidadeId id = new UsuarioFuncionalidadeId(
                    usuario.getId(),
                    funcionalidade.getId()
            );

            UsuarioFuncionalidade usuarioFunc = new UsuarioFuncionalidade();
            usuarioFunc.setId(id);
            usuarioFunc.setFuncionalidade(funcionalidade);
            usuarioFunc.setUsuario(usuario);
            usuarioFunc.setLeitura(funcionalidadeRequest.leitura());
            usuarioFunc.setEscrita(funcionalidadeRequest.escrita());

            usuarioFuncionalidadeRepository.save(usuarioFunc);
        }

        return new ApiResponse("Cadastro realizado com sucesso!", true);
    }

}
