package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.RequestAgentFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.UserPermissionsDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentFeature;
import br.gov.pa.iasep.opmepro_api.services.AgentFeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/agent-features")
public class AgentFeatureController {

    private final AgentFeatureService agentFeatureService;

    public AgentFeatureController(AgentFeatureService agentFeatureService) {
        this.agentFeatureService = agentFeatureService;
    }

    @GetMapping("/all-permissions")
    public ResponseEntity<List<UserPermissionsDTO>> getAllPermissions(@RequestParam Integer code){
        return ResponseEntity.status(HttpStatus.OK).body(agentFeatureService.getAllPermissions(code));
    }

    @PostMapping("/assign-feature")
    public ResponseEntity<ApiResponse> assignFeature(@RequestBody RequestAgentFeatureDTO[] agentFeature){
        for(RequestAgentFeatureDTO feature : agentFeature){
             agentFeatureService.assignFeature(feature);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ApiResponse("Dados atualizados com sucesso!", true)
        );
    }

}
