package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoAtualizarDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.CredenciadoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credenciado")
public class CredenciadoController {

    private final CredenciadoService credenciadoService;

    public CredenciadoController(CredenciadoService credenciadoService) {
        this.credenciadoService = credenciadoService;
    }

    @GetMapping("/credenciados")
    public ResponseEntity<List<CredenciadoResumidoDTO>> getCredenciados(){
        List<CredenciadoResumidoDTO> accreditedList = credenciadoService.getCredenciados();
        return ResponseEntity.status(HttpStatus.OK).body(accreditedList);
    }

    @PostMapping("/cadastrar-credenciado")
    public ResponseEntity<ApiResponse> cadastrarCredenciado(@RequestBody CredenciadoCadastroDTO credenciado){
        ApiResponse response = credenciadoService.postCredenciado(credenciado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/atualizar-credenciado")
    public ResponseEntity<ApiResponse> atualizarCredenciado(@RequestBody CredenciadoAtualizarDTO credenciado){
        ApiResponse response = credenciadoService.atualizarCredenciado(credenciado);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
