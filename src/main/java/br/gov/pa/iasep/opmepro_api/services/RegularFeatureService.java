package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.FeatureNotFoundException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.RequestRegularFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.*;
import br.gov.pa.iasep.opmepro_api.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class RegularFeatureService {

    private final RegularFeatureRepository regularFeatureRepository;
    private final FeatureRepository featureRepository;
    private final RegularUserRepository regularUserRepository;

    public RegularFeatureService(
            RegularFeatureRepository regularFeatureRepository,
            FeatureRepository featureRepository,
            RegularUserRepository regularUserRepository)
    {
        this.regularFeatureRepository = regularFeatureRepository;
        this.featureRepository = featureRepository;
        this.regularUserRepository = regularUserRepository;
    }

    public void assignFeature(RequestRegularFeatureDTO userFeature){

        Feature feature = featureRepository.findById(userFeature.featureCode())
                .orElseThrow(() -> new FeatureNotFoundException("Funcionalidade não encontrada!"));

        RegularUser regularUser = regularUserRepository.findById(userFeature.userCode())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        RegularUserFeature regularUserFeature = new RegularUserFeature();
        regularUserFeature.setFeature(feature);
        regularUserFeature.setRegularUser(regularUser);
        regularUserFeature.setReading(userFeature.reading());
        regularUserFeature.setWriting(userFeature.writing());

        regularFeatureRepository.save(regularUserFeature);
    }

}
