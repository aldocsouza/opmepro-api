package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.FeatureNotFoundException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.RequestUsuarioFuncionalidadeDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioFuncionalidadeDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioPermissoesDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Funcionalidade;
import br.gov.pa.iasep.opmepro_api.model.entities.Usuario;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioFuncionalidade;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UsuarioFuncionalidadeMapper;
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
    private final UsuarioFuncionalidadeMapper usuarioFuncionalidadeMapper;

    public UsuarioFuncionalidadeService(
            UsuarioFuncionalidadeRepository usuarioFuncionalidadeRepository,
            FuncionalidadeRepository funcionalidadeRepository,
            UsuarioRepository usuarioRepository,
            UsuarioFuncionalidadeMapper usuarioFuncionalidadeMapper
    )
    {
        this.usuarioFuncionalidadeRepository = usuarioFuncionalidadeRepository;
        this.funcionalidadeRepository = funcionalidadeRepository;
        this.usuarioRepository = usuarioRepository;
        this.usuarioFuncionalidadeMapper = usuarioFuncionalidadeMapper;
    }

    public List<UsuarioPermissoesDTO> getPermissoes(Integer id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        return usuarioFuncionalidadeRepository.findByUsuario(usuario)
                .stream()
                .map(usuarioFuncionalidadeMapper::toUsuarioPermissoesDTO)
                .collect(Collectors.toList());
    }

    public void atribuirFuncionalidade(RequestUsuarioFuncionalidadeDTO usuarioFuncionalidade){

        Funcionalidade funcionalidade = funcionalidadeRepository.findById(usuarioFuncionalidade.idFuncionalidade())
                .orElseThrow(() -> new FeatureNotFoundException("Funcionalidade não encontrada!"));

        Usuario usuario = usuarioRepository.findById(usuarioFuncionalidade.idUsuario())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        UsuarioFuncionalidade usuarioFunc = new UsuarioFuncionalidade();
        usuarioFunc.setFuncionalidade(funcionalidade);
        usuarioFunc.setUsuario(usuario);
        usuarioFunc.setLeitura(usuarioFuncionalidade.leitura());
        usuarioFunc.setEscrita(usuarioFuncionalidade.escrita());

        usuarioFuncionalidadeRepository.save(usuarioFunc);
    }

}
