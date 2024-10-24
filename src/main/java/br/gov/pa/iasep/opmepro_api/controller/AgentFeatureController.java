package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.RequestAgentFeatureDTO;
import br.gov.pa.iasep.opmepro_api.services.AgentFeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent-features")
public class AgentFeatureController {

    private final AgentFeatureService agentFeatureService;

    public AgentFeatureController(AgentFeatureService agentFeatureService) {
        this.agentFeatureService = agentFeatureService;
    }

    @PostMapping("/assign-feature")
    public ResponseEntity<ApiResponse> assignFeature(@RequestBody RequestAgentFeatureDTO agentFeature){
        agentFeatureService.assignFeature(agentFeature);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("Cadastro realizado com sucesso!", true));
    }

}
