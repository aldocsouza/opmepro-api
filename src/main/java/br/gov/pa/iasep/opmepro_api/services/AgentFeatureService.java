package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.FeatureAlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.FeatureNotFoundException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.RequestAgentFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.UserPermissionsDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentFeature;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.Feature;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserFeatureMapper;
import br.gov.pa.iasep.opmepro_api.repositories.AgentFeatureRepository;
import br.gov.pa.iasep.opmepro_api.repositories.AgentUserRepository;
import br.gov.pa.iasep.opmepro_api.repositories.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentFeatureService {

    private final AgentFeatureRepository agentFeatureRepository;
    private final FeatureRepository featureRepository;
    private final AgentUserRepository agentUserRepository;
    private final UserFeatureMapper userFeatureMapper;

    public AgentFeatureService(
            AgentFeatureRepository agentFeatureRepository, FeatureRepository featureRepository,
            AgentUserRepository agentUserRepository, UserFeatureMapper userFeatureMapper
    ) {
        this.agentFeatureRepository = agentFeatureRepository;
        this.featureRepository = featureRepository;
        this.agentUserRepository = agentUserRepository;
        this.userFeatureMapper = userFeatureMapper;
    }

    public List<UserPermissionsDTO> getAllPermissions(Integer code){
        AgentUser agentUser = agentUserRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        return agentFeatureRepository.findByAgent(agentUser)
                .stream()
                .map(userFeatureMapper::toUserPermissionsDTO)
                .collect(Collectors.toList());
    }

    public void assignFeature(RequestAgentFeatureDTO agentFeature){

        Feature feature = featureRepository.findById(agentFeature.featureCode())
                .orElseThrow(() -> new FeatureNotFoundException("Funcionalidade não encontrada!"));

        AgentUser agentUser = agentUserRepository.findById(agentFeature.agentCode())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        AgentFeature newAgentFeature = new AgentFeature();
        newAgentFeature.setFeature(feature);
        newAgentFeature.setAgent(agentUser);
        newAgentFeature.setReading(agentFeature.reading());
        if(agentFeature.reading()){
            newAgentFeature.setWriting(agentFeature.writing());
        } else {
            newAgentFeature.setWriting(false);
        }

        agentFeatureRepository.save(newAgentFeature);
    }

}
