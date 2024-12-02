package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.FeatureNotFoundException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.RequestRegularFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.UserPermissionsDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Funcionalidade;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioFuncionalidade;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserFeatureMapper;
import br.gov.pa.iasep.opmepro_api.repositories.FeatureRepository;
import br.gov.pa.iasep.opmepro_api.repositories.UserFeatureRepository;
import br.gov.pa.iasep.opmepro_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegularFeatureService {

    private final UserFeatureRepository userFeatureRepository;
    private final FeatureRepository featureRepository;
    private final UserRepository userRepository;
    private final UserFeatureMapper userFeatureMapper;

    public RegularFeatureService(
            UserFeatureRepository userFeatureRepository,
            FeatureRepository featureRepository,
            UserRepository userRepository,
            UserFeatureMapper userFeatureMapper
    )
    {
        this.userFeatureRepository = userFeatureRepository;
        this.featureRepository = featureRepository;
        this.userRepository = userRepository;
        this.userFeatureMapper = userFeatureMapper;
    }

    public List<UserPermissionsDTO> getAllPermissions(Integer code){
        RegularUser regularUser = userRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        return userFeatureRepository.findByRegularUser(regularUser)
                .stream()
                .map(userFeatureMapper::toUserPermissionsDTO)
                .collect(Collectors.toList());
    }

    public void assignFeature(RequestRegularFeatureDTO userFeature){

        Funcionalidade funcionalidade = featureRepository.findById(userFeature.featureCode())
                .orElseThrow(() -> new FeatureNotFoundException("Funcionalidade não encontrada!"));

        RegularUser regularUser = userRepository.findById(userFeature.userCode())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        UsuarioFuncionalidade regularUsuarioFuncionalidade = new UsuarioFuncionalidade();
        regularUsuarioFuncionalidade.setFuncionalidade(funcionalidade);
        regularUsuarioFuncionalidade.setRegularUser(regularUser);
        regularUsuarioFuncionalidade.setReading(userFeature.reading());
        regularUsuarioFuncionalidade.setWriting(userFeature.writing());

        userFeatureRepository.save(regularUsuarioFuncionalidade);
    }

}
