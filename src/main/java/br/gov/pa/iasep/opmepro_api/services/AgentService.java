package br.gov.pa.iasep.opmepro_api.services;

import org.springframework.stereotype.Service;

@Service
public class AgentService {

//    private final AgentUserRepository agentUserRepository;
//    private final UserMapper userMapper;
//    private final UserValidationService userValidationService;
//
//    public AgentService(
//            AgentUserRepository agentUserRepository, UserMapper userMapper,
//            UserValidationService userValidationService
//    ){
//        this.agentUserRepository = agentUserRepository;
//        this.userMapper = userMapper;
//        this.userValidationService = userValidationService;
//    }
//
//    public List<ResponseAgentDTO> getAllAgents(){
//        return agentUserRepository.findAll()
//                .stream()
//                .map(userMapper::toAgentDTO)
//                .toList();
//    }
//
//    public List<ResponseAgentAndFeaturesDTO> getAllAgentsAndFeatures(){
//        return agentUserRepository.findAll()
//                .stream()
//                .map(userMapper::toAgentAndFeaturesDTO)
//                .toList();
//    }
//
//    public List<ResponseAgentNoListDTO> getAllAgentsNoList(){
//        return agentUserRepository.findAll()
//                .stream()
//                .map(userMapper::toAgentNoListDTO)
//                .toList();
//    }
//
//    public ApiResponse updateAgent(AgentUserUpdateDTO updateDTO){
//        AgentUser agentUser = agentUserRepository.findById(updateDTO.code())
//                .orElseThrow(null);
//
//        if(agentUser == null) throw new NotFoundException("Usuário não encontrado");
//
//        if(!agentUser.getCpf().equals(updateDTO.cpf())){
//            this.userValidationService.checkForDuplicateCpf(updateDTO.cpf());
//            agentUser.setCpf(updateDTO.cpf());
//        }
//
//        if(!agentUser.getRegistry().equals(updateDTO.registry())){
//            this.userValidationService.checkForDuplicateRegistry(updateDTO.registry());
//            agentUser.setRegistry(updateDTO.registry());
//            agentUser.setAffiliation(updateDTO.affiliation());
//        }
//
//        if(!agentUser.getUsername().equals(updateDTO.username())){
//            this.userValidationService.checkForDuplicateUsername(updateDTO.username());
//            agentUser.setUsername(updateDTO.username());
//        }
//
//         if(!agentUser.getEmail().equals(updateDTO.email())){
//             this.userValidationService.checkForDuplicateEmail(updateDTO.email());
//             agentUser.setEmail(updateDTO.email());
//        }
//
//        agentUser.setCode(updateDTO.code());
//        agentUser.setName(updateDTO.name());
//
//        if(updateDTO.password() != null){
//            String encryptedPassword = new BCryptPasswordEncoder().encode(updateDTO.password());
//            agentUser.setPassword(encryptedPassword);
//        }
//
//        agentUser.setPhone(updateDTO.phone());
//        agentUser.setStatus(updateDTO.status());
//        agentUser.setRole(updateDTO.role());
//
//        agentUserRepository.save(agentUser);
//
//        return new ApiResponse("Dados atualizados com sucesso.", true);
//    }

}
