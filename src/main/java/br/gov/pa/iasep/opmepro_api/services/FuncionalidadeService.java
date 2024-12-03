package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Funcionalidade;
import br.gov.pa.iasep.opmepro_api.repositories.FuncionalidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionalidadeService {

    private final FuncionalidadeRepository funcionalidadeRepository;

    public FuncionalidadeService(FuncionalidadeRepository funcionalidadeRepository){
        this.funcionalidadeRepository = funcionalidadeRepository;
    }

    public List<FuncionalidadeResumidoDTO> getFuncionalidades(){
        return funcionalidadeRepository.findAll()
                .stream()
                .map(feature -> new FuncionalidadeResumidoDTO(feature.getId(), feature.getDescricao()))
                .toList();
    }

    public ApiResponse cadastrarFuncionalidade(FuncionalidadeCadastroDTO funcionalidade){
        Funcionalidade newFuncionalidade = new Funcionalidade();
        newFuncionalidade.setDescricao(funcionalidade.descricao());
        funcionalidadeRepository.save(newFuncionalidade);

        return new ApiResponse("Cadastro realizado com sucesso!", true);
    }
}
