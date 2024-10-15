package br.gov.pa.iasep.copme_api.controller;

import br.gov.pa.iasep.copme_api.model.entities.DTOs.LoginRequestDTO;
import br.gov.pa.iasep.copme_api.model.entities.DTOs.LoginResponseDTO;
import br.gov.pa.iasep.copme_api.model.entities.DTOs.RequestUserDTO;
import br.gov.pa.iasep.copme_api.model.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@RequestBody @Valid RequestUserDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                authenticationService.createAccountService(user)
        );
    }

}
