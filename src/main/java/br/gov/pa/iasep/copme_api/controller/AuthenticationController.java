package br.gov.pa.iasep.copme_api.controller;

import br.gov.pa.iasep.copme_api.model.entities.DTOs.*;
import br.gov.pa.iasep.copme_api.model.services.AuthenticationService;
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

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerAccount(@RequestBody @Valid RequestUserDTO user){
        ApiResponse register = authenticationService.createAccountService(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);
    }

}
