package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.ProcedimentoAtualizarDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.ProcedimentoDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.ProcedimentoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.ProcedimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procedimentos")
public class ProcedimentoController {

    private final ProcedimentoService procedimentoService;

    public ProcedimentoController(ProcedimentoService procedimentoService) {
        this.procedimentoService = procedimentoService;
    }

    @GetMapping("/resumidos")
    public ResponseEntity<List<ProcedimentoResumidoDTO>> obterTodosProcedimento(){
        return ResponseEntity.status(HttpStatus.OK).body(procedimentoService.obterTodosProcedimento());
    }

    @GetMapping("/detalhado")
    public ResponseEntity<ProcedimentoDetalhadoDTO> obterProcedimento(@RequestParam String codigo){
        return ResponseEntity.status(HttpStatus.OK).body(procedimentoService.obterProcedimento(codigo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarProcedimento(@PathVariable("id") Integer id, @RequestBody ProcedimentoAtualizarDTO procedimentoDto){
        ApiResponse response = procedimentoService.atualizarProcedimento(id, procedimentoDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }


}
