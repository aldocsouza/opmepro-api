package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.ResponseAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.RegularUserUpdateDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserNoListDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponserRegularUserAndFeaturesDTO;
import br.gov.pa.iasep.opmepro_api.services.RegularUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regular")
public class UsuarioController {

    private final RegularUserService regularUserService;

    public UsuarioController(RegularUserService regularUserService) {
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

    @GetMapping("/users-accredited")
    public ResponseEntity<ResponseAccreditedDTO> getAccreditedFromUser(@RequestParam Integer code){
        return ResponseEntity.status(HttpStatus.OK).body(regularUserService.getAccreditedFromUser(code));
    }

    @PutMapping("/update-no-list")
    public ResponseEntity<ApiResponse> updateRegularUser(@RequestBody RegularUserUpdateDTO updateDTO){
        ApiResponse update = regularUserService.updateRegularUser(updateDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
    }
}
