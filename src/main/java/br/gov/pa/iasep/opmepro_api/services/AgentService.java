package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.AgentUserUpdateDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.ResponseAgentAndFeaturesDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.ResponseAgentDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.ResponseAgentNoListDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.opmepro_api.repositories.AgentUserRepository;
import br.gov.pa.iasep.opmepro_api.repositories.RegularUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    private final AgentUserRepository agentUserRepository;
    private final RegularUserRepository regularUserRepository;
    private final UserMapper userMapper;

    public AgentService(AgentUserRepository agentUserRepository, UserMapper userMapper, RegularUserRepository regularUserRepository){
        this.agentUserRepository = agentUserRepository;
        this.regularUserRepository = regularUserRepository;
        this.userMapper = userMapper;
    }

    public List<ResponseAgentDTO> getAllAgents(){
        return agentUserRepository.findAll()
                .stream()
                .map(userMapper::toAgentDTO)
                .toList();
    }

    public List<ResponseAgentAndFeaturesDTO> getAllAgentsAndFeatures(){
        return agentUserRepository.findAll()
                .stream()
                .map(userMapper::toAgentAndFeaturesDTO)
                .toList();
    }

    public List<ResponseAgentNoListDTO> getAllAgentsNoList(){
        return agentUserRepository.findAll()
                .stream()
                .map(userMapper::toAgentNoListDTO)
                .toList();
    }

    public ApiResponse updateAgent(AgentUserUpdateDTO updateDTO){
        AgentUser agentUser = agentUserRepository.findById(updateDTO.code())
                .orElseThrow(null);

        if(agentUser == null) throw new NotFoundException("Usuário não encontrado");

        if(!agentUser.getCpf().equals(updateDTO.cpf())){
            if(agentUserRepository.findByCpf(updateDTO.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
            if(regularUserRepository.findByCpf(updateDTO.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
            agentUser.setCpf(updateDTO.cpf());
        }

        if(!agentUser.getRegistry().equals(updateDTO.registry())){
            if(agentUserRepository.findByRegistry(updateDTO.registry()) != null) throw new AlreadyExistsException("Já existe um usuário com a matrícula informada");
            agentUser.setRegistry(updateDTO.registry());
            agentUser.setAffiliation(updateDTO.affiliation());
        }

        if(!agentUser.getUsername().equals(updateDTO.username())){
            if(agentUserRepository.findByUsername(updateDTO.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
            if(regularUserRepository.findByUsername(updateDTO.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
            agentUser.setUsername(updateDTO.username());
        }

         if(!agentUser.getEmail().equals(updateDTO.email())){
             if(agentUserRepository.findByEmail(updateDTO.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");
             if(regularUserRepository.findByEmail(updateDTO.email()) != null) throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");
             agentUser.setEmail(updateDTO.email());
        }

        agentUser.setCode(updateDTO.code());
        agentUser.setName(updateDTO.name());

        if(updateDTO.password() != null){
            String encryptedPassword = new BCryptPasswordEncoder().encode(updateDTO.password());
            agentUser.setPassword(encryptedPassword);
        }

        agentUser.setPhone(updateDTO.phone());
        agentUser.setStatus(updateDTO.status());
        agentUser.setRole(updateDTO.role());

        agentUserRepository.save(agentUser);

        return new ApiResponse("Dados atualizados com sucesso.", true);
    }

}
