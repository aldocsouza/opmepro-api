package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.RequestFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Feature;
import br.gov.pa.iasep.opmepro_api.services.FeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService){
        this.featureService = featureService;
    }

    @GetMapping("/all-features")
    public ResponseEntity<List<Feature>> getAllFeatures(){
        return ResponseEntity.status(HttpStatus.OK).body(featureService.getAllFeatures());
    }

    @PostMapping("/create-feature")
    public ResponseEntity<ApiResponse> createFeature(@RequestBody RequestFeatureDTO feature){
        ApiResponse response = featureService.createFeature(feature);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
