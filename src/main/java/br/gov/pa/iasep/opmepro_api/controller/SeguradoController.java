package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoAtualizarDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.SeguradoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/segurados")
public class SeguradoController {

    private final SeguradoService seguradoService;

    public SeguradoController(SeguradoService seguradoService) {
        this.seguradoService = seguradoService;
    }

    @GetMapping("/detalhados")
    public ResponseEntity<List<SeguradoDetalhadoDTO>> obterTodosSergurados(){
        return ResponseEntity.status(HttpStatus.OK).body(seguradoService.obterTodosSergurados());
    }

    @GetMapping("/segurado")
    public ResponseEntity<SeguradoResumidoDTO> obterSeguradoResumido(@RequestParam String consulta){
        return ResponseEntity.status(HttpStatus.OK).body(seguradoService.obterSeguradoResumido(consulta));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ApiResponse> cadastrarSegurado(@RequestBody SeguradoCadastroDTO segurado){
        ApiResponse response = seguradoService.cadastrarSegurado(segurado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ApiResponse> atualizarDadosSegurado(@PathVariable("id") Integer id, @RequestBody SeguradoAtualizarDTO seguradoUpdate){
        ApiResponse response = seguradoService.atualizarDadosSegurado(id, seguradoUpdate);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
