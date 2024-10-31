package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.RequestRegularFeatureDTO;
import br.gov.pa.iasep.opmepro_api.services.RegularFeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/regular-features")
public class RegularFeatureController {

    private final RegularFeatureService regularFeatureService;

    public RegularFeatureController(RegularFeatureService regularFeatureService) {
        this.regularFeatureService = regularFeatureService;
    }

    @PostMapping("/assign-feature")
    public ResponseEntity<ApiResponse> assignFeature(@RequestBody RequestRegularFeatureDTO userFeature){
        regularFeatureService.assignFeature(userFeature);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("Cadastro realizado com sucesso!", true));
    }
}
