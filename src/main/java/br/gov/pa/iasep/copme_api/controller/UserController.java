package br.gov.pa.iasep.copme_api.controller;

import br.gov.pa.iasep.copme_api.model.entities.DTOs.LoginRequestDTO;
import br.gov.pa.iasep.copme_api.model.entities.DTOs.LoginResponseDTO;
import br.gov.pa.iasep.copme_api.model.entities.DTOs.RequestUserDTO;
import br.gov.pa.iasep.copme_api.model.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        LoginResponseDTO auth = userService.login(loginRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(auth);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@RequestBody @Valid RequestUserDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                userService.createAccountService(user)
        );
    }

}
