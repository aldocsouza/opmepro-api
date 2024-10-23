package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.model.dtos.UserAgentDTOs.ResponseAgentDTO;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.AgentMapper;
import br.gov.pa.iasep.opmepro_api.repositories.AgentUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentService {

    private final AgentUserRepository agentUserRepository;
    private final AgentMapper agentMapper;

    public AgentService(AgentUserRepository agentUserRepository, AgentMapper agentMapper){
        this.agentUserRepository = agentUserRepository;
        this.agentMapper = agentMapper;
    }

    public List<ResponseAgentDTO> getAllAgents(){
        return agentUserRepository.findAll().stream().map(agentMapper::toResponseDTO).toList();
    }

}
