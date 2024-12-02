package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.FeatureCreateDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.ResponseFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Funcionalidade;
import br.gov.pa.iasep.opmepro_api.repositories.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository){
        this.featureRepository = featureRepository;
    }

    public List<ResponseFeatureDTO> getAllFeatures(){
        return featureRepository.findAll()
                .stream()
                .map(feature -> new ResponseFeatureDTO(feature.getCode(), feature.getDescription())).toList();
    }

    public ApiResponse createFeature(FeatureCreateDTO feature){
        Funcionalidade newFuncionalidade = new Funcionalidade();
        newFuncionalidade.setDescription(feature.description());
        featureRepository.save(newFuncionalidade);

        return new ApiResponse("Cadastro realizado com sucesso!", true);
    }
}
