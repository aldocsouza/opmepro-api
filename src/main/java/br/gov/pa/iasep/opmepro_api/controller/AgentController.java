package br.gov.pa.iasep.opmepro_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

//    private final AgentService agentService;
//
//    public AgentController(AgentService agentService){
//        this.agentService = agentService;
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<ResponseAgentDTO>> getAllAgents(){
//        return ResponseEntity.status(HttpStatus.OK).body(agentService.getAllAgents());
//    }
//
//    @GetMapping("/users-features")
//    public ResponseEntity<List<ResponseAgentAndFeaturesDTO>> getAllAgentsAndFeatures(){
//        return ResponseEntity.status(HttpStatus.OK).body(agentService.getAllAgentsAndFeatures());
//    }
//
//    @GetMapping("/users-no-list")
//    public ResponseEntity<List<ResponseAgentNoListDTO>> getAllAgentsNoList(){
//        return ResponseEntity.status(HttpStatus.OK).body(agentService.getAllAgentsNoList());
//    }
//
//    @PutMapping("/update-no-list")
//    public ResponseEntity<ApiResponse> updateAgent(@RequestBody AgentUserUpdateDTO updateDTO){
//        ApiResponse update = agentService.updateAgent(updateDTO);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
//    }
}
