package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.RequestRegularFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.UserPermissionsDTO;
import br.gov.pa.iasep.opmepro_api.services.RegularFeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regular-features")
public class RegularFeatureController {

    private final RegularFeatureService regularFeatureService;

    public RegularFeatureController(RegularFeatureService regularFeatureService) {
        this.regularFeatureService = regularFeatureService;
    }

    @GetMapping("/all-permissions")
    public ResponseEntity<List<UserPermissionsDTO>> getAllPermissions(@RequestParam Integer code){
        return ResponseEntity.status(HttpStatus.OK).body(regularFeatureService.getAllPermissions(code));
    }

    @PostMapping("/assign-feature")
    public ResponseEntity<ApiResponse> assignFeature(@RequestBody RequestRegularFeatureDTO[] userFeature){
        for (RequestRegularFeatureDTO feature : userFeature){
            regularFeatureService.assignFeature(feature);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("Cadastro realizado com sucesso!", true));
    }
}
