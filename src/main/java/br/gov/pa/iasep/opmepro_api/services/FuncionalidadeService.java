package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Funcionalidade;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.FuncionalidadeMapper;
import br.gov.pa.iasep.opmepro_api.repositories.FuncionalidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionalidadeService {

    private final FuncionalidadeRepository funcionalidadeRepository;
    private final FuncionalidadeMapper funcionalidadeMapper;

    public FuncionalidadeService(FuncionalidadeRepository funcionalidadeRepository, FuncionalidadeMapper funcionalidadeMapper) {
        this.funcionalidadeRepository = funcionalidadeRepository;
        this.funcionalidadeMapper = funcionalidadeMapper;
    }

    public List<FuncionalidadeResumidoDTO> getFuncionalidades(){
        return funcionalidadeRepository.findAll()
                .stream()
                .map(feature -> new FuncionalidadeResumidoDTO(feature.getId(), feature.getDescricao()))
                .toList();
    }

    public FuncionalidadeDetalhadoDTO getFuncionalidadeComUsuarios(Integer id){
        Funcionalidade funcionalidade = funcionalidadeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Funcionalidade não encontrada!"));

        return funcionalidadeMapper.toFuncionalidadeDetalhadoDTO(funcionalidade);
    }

    public ApiResponse cadastrarFuncionalidade(FuncionalidadeCadastroDTO funcionalidadeDTO){
        Funcionalidade newFuncionalidade = new Funcionalidade();
        newFuncionalidade.setDescricao(funcionalidadeDTO.descricao());
        funcionalidadeRepository.save(newFuncionalidade);

        return new ApiResponse("Cadastro realizado com sucesso!", true);
    }

    public ApiResponse atualizarFuncionalidade(FuncionalidadeResumidoDTO funcionalidadeDTO) {
        Funcionalidade funcionalidade = funcionalidadeRepository.findById(funcionalidadeDTO.id())
                .orElseThrow(() -> new NotFoundException("Funcionalidade não encontrada!"));

        funcionalidade.setDescricao(funcionalidadeDTO.descricao());
        funcionalidadeRepository.save(funcionalidade);

        return new ApiResponse("Dados atualizados com sucesso!", true);
    }
}
