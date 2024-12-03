package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.FuncionalidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionalidade")
public class FuncionalidadeController {

    private final FuncionalidadeService funcionalidadeService;

    public FuncionalidadeController(FuncionalidadeService funcionalidadeService){
        this.funcionalidadeService = funcionalidadeService;
    }

    @GetMapping("/funcionalidades")
    public ResponseEntity<List<FuncionalidadeResumidoDTO>> getFuncionalidades(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionalidadeService.getFuncionalidades());
    }

    @PostMapping("/cadastrar-funcionalidade")
    public ResponseEntity<ApiResponse> cadastrarFuncionalidade(@RequestBody FuncionalidadeCadastroDTO feature){
        ApiResponse response = funcionalidadeService.cadastrarFuncionalidade(feature);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
