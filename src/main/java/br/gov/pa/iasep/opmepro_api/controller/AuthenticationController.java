package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginRequestDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginResponseDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioCadastroDTO;
import br.gov.pa.iasep.opmepro_api.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletRequest request){
        LoginResponseDTO auth = authenticationService.login(loginRequestDTO, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(auth);
    }

    @PostMapping("/cadastrar-usuario")
    public ResponseEntity<ApiResponse> cadastrarUsuario(@RequestBody @Valid UsuarioCadastroDTO usuario){
        ApiResponse register = authenticationService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);
    }
}
