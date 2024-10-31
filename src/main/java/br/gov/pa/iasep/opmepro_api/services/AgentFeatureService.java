package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.FeatureNotFoundException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.RequestAgentFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentFeature;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.Feature;
import br.gov.pa.iasep.opmepro_api.repositories.AgentFeatureRepository;
import br.gov.pa.iasep.opmepro_api.repositories.AgentUserRepository;
import br.gov.pa.iasep.opmepro_api.repositories.FeatureRepository;
import org.springframework.stereotype.Service;

@Service
public class AgentFeatureService {

    private final AgentFeatureRepository agentFeatureRepository;
    private final FeatureRepository featureRepository;
    private final AgentUserRepository agentUserRepository;

    public AgentFeatureService(AgentFeatureRepository agentFeatureRepository, FeatureRepository featureRepository, AgentUserRepository agentUserRepository) {
        this.agentFeatureRepository = agentFeatureRepository;
        this.featureRepository = featureRepository;
        this.agentUserRepository = agentUserRepository;
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
        newAgentFeature.setWriting(agentFeature.writing());

        agentFeatureRepository.save(newAgentFeature);
    }

}
