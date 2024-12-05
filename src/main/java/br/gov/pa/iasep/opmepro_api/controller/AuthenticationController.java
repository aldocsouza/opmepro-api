package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginRequestDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginResponseDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioCadastroDTO;
import br.gov.pa.iasep.opmepro_api.services.AuthenticationService;
import br.gov.pa.iasep.opmepro_api.services.HistoricoSessaoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final HistoricoSessaoService historicoSessaoService;

    public AuthenticationController(AuthenticationService authenticationService, HistoricoSessaoService historicoSessaoService) {
        this.authenticationService = authenticationService;
        this.historicoSessaoService = historicoSessaoService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletRequest request){
        LoginResponseDTO auth = authenticationService.login(loginRequestDTO, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(auth);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ApiResponse> cadastrarUsuario(@RequestBody @Valid UsuarioCadastroDTO usuario){
        ApiResponse register = authenticationService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);
    }

    @PutMapping("/logout/{id}")
    public ResponseEntity<Void> registrarLogout(@PathVariable Integer id){
        historicoSessaoService.registrarLogout(id);
        return ResponseEntity.noContent().build();
    }
}
