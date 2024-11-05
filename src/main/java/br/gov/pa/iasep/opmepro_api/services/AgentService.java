package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.ResponseAgentDTO;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.opmepro_api.repositories.AgentUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    private final AgentUserRepository agentUserRepository;
    private final UserMapper userMapper;

    public AgentService(AgentUserRepository agentUserRepository, UserMapper userMapper){
        this.agentUserRepository = agentUserRepository;
        this.userMapper = userMapper;
    }

    public List<ResponseAgentDTO> getAllAgents(){
        return agentUserRepository.findAll()
                .stream()
                .map(userMapper::toResponseAgentDTO)
                .toList();
    }

}
