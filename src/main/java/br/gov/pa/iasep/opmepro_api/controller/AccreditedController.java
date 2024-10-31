package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.RequestAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.ResponseAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.entities.Accredited;
import br.gov.pa.iasep.opmepro_api.services.AccreditedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accredited")
public class AccreditedController {

    private final AccreditedService accreditedService;

    public AccreditedController(AccreditedService accreditedService) {
        this.accreditedService = accreditedService;
    }

    @GetMapping("/all-accredited")
    public ResponseEntity<List<ResponseAccreditedDTO>> getAllAccredites(){
        List<ResponseAccreditedDTO> accreditedList = accreditedService.getAllAcrredited();
        return ResponseEntity.status(HttpStatus.OK).body(accreditedList);
    }

    @PostMapping("/create-accredited")
    public ResponseEntity<ApiResponse> createAccredited(@RequestBody RequestAccreditedDTO accredited){
        ApiResponse response = accreditedService.createAccredited(accredited);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
