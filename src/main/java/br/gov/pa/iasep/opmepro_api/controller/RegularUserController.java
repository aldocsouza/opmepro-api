package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.ResponseAgentAndFeaturesDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.ResponseAgentNoListDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserNoListDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponserRegularUserAndFeaturesDTO;
import br.gov.pa.iasep.opmepro_api.services.RegularUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/regular")
public class RegularUserController {

    private final RegularUserService regularUserService;

    public RegularUserController(RegularUserService regularUserService) {
        this.regularUserService = regularUserService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseRegularUserDTO>> getAllRegularUsers(){
        List<ResponseRegularUserDTO> response = regularUserService.getAllRegularUsers();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/users-features")
    public ResponseEntity<List<ResponserRegularUserAndFeaturesDTO>> getAllRegularUsersAndFeatures(){
        return ResponseEntity.status(HttpStatus.OK).body(regularUserService.getAllRegularUsersAndFeatures());
    }

    @GetMapping("/users-no-list")
    public ResponseEntity<List<ResponseRegularUserNoListDTO>> getAllRegularUsersNoList(){
        return ResponseEntity.status(HttpStatus.OK).body(regularUserService.getAllRegularUsersNoList());
    }

}
