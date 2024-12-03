package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.CredenciadoService;
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
    public ResponseEntity<ApiResponse> cadastrarCredenciado(@RequestBody CredenciadoCadastroDTO accredited){
        ApiResponse response = credenciadoService.postCredenciado(accredited);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
