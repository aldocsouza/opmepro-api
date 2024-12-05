package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.FuncionalidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionalidades")
public class FuncionalidadeController {

    private final FuncionalidadeService funcionalidadeService;

    public FuncionalidadeController(FuncionalidadeService funcionalidadeService){
        this.funcionalidadeService = funcionalidadeService;
    }

    @GetMapping("/resumidos")
    public ResponseEntity<List<FuncionalidadeResumidoDTO>> obterFuncionalidadesResumidos(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionalidadeService.obterFuncionalidadesResumidos());
    }

    @GetMapping("/detalhado/{id}")
    public ResponseEntity<FuncionalidadeDetalhadoDTO> obterFuncionalidadeDetalhada(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(funcionalidadeService.obterFuncionalidadeDetalhada(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ApiResponse> cadastrarFuncionalidade(@RequestBody FuncionalidadeCadastroDTO funcionalidadeDTO){
        ApiResponse response = funcionalidadeService.cadastrarFuncionalidade(funcionalidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarFuncionalidade(@PathVariable("id") Integer id, @RequestBody FuncionalidadeResumidoDTO funcionalidadeDTO){
        ApiResponse response = funcionalidadeService.atualizarFuncionalidade(id, funcionalidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
