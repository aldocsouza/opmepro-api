package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginRequestDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginResponseDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UserAgentDTOs.RequestUserAgentDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UserDTOs.RequestUserDTO;
import br.gov.pa.iasep.opmepro_api.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        LoginResponseDTO auth = authenticationService.login(loginRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(auth);
    }

    @PostMapping("/register-user-agent")
    public ResponseEntity<ApiResponse> registerUserAgentAccount(@RequestBody @Valid RequestUserAgentDTO userAgent){
        ApiResponse register = authenticationService.createAgentAccount(userAgent);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);
    }

}
