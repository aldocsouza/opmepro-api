package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoAtualizarDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.CredenciadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credenciados")
public class CredenciadoController {

    private final CredenciadoService credenciadoService;

    public CredenciadoController(CredenciadoService credenciadoService) {
        this.credenciadoService = credenciadoService;
    }

    @GetMapping("/resumidos")
    public ResponseEntity<List<CredenciadoResumidoDTO>> obterCredenciadosResumidos(){
        List<CredenciadoResumidoDTO> credenciados = credenciadoService.obterCredenciados();
        return ResponseEntity.status(HttpStatus.OK).body(credenciados);
    }

    @GetMapping("/detalhado/{id}")
    public ResponseEntity<CredenciadoDetalhadoDTO> obterCredenciadoDetalhado(@PathVariable("id") Integer id){
        CredenciadoDetalhadoDTO credenciado = credenciadoService.obterCredenciadoDetalhado(id);
        return ResponseEntity.status(HttpStatus.OK).body(credenciado);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ApiResponse> cadastrarCredenciado(@RequestBody CredenciadoCadastroDTO credenciado){
        ApiResponse response = credenciadoService.cadastrarCredenciado (credenciado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarCredenciado(@PathVariable("id") Integer id, @RequestBody CredenciadoAtualizarDTO credenciado){
        ApiResponse response = credenciadoService.atualizarCredenciado(id, credenciado);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
