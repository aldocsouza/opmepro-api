package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.FeatureNotFoundException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.RequestRegularFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.UserPermissionsDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Feature;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUserFeature;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserFeatureMapper;
import br.gov.pa.iasep.opmepro_api.repositories.FeatureRepository;
import br.gov.pa.iasep.opmepro_api.repositories.RegularFeatureRepository;
import br.gov.pa.iasep.opmepro_api.repositories.RegularUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegularFeatureService {

    private final RegularFeatureRepository regularFeatureRepository;
    private final FeatureRepository featureRepository;
    private final RegularUserRepository regularUserRepository;
    private final UserFeatureMapper userFeatureMapper;

    public RegularFeatureService(
            RegularFeatureRepository regularFeatureRepository,
            FeatureRepository featureRepository,
            RegularUserRepository regularUserRepository,
            UserFeatureMapper userFeatureMapper
    )
    {
        this.regularFeatureRepository = regularFeatureRepository;
        this.featureRepository = featureRepository;
        this.regularUserRepository = regularUserRepository;
        this.userFeatureMapper = userFeatureMapper;
    }

    public List<UserPermissionsDTO> getAllPermissions(Integer code){
        RegularUser regularUser = regularUserRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        return regularFeatureRepository.findByRegularUser(regularUser)
                .stream()
                .map(userFeatureMapper::toUserPermissionsDTO)
                .collect(Collectors.toList());
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
