package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialAtualizacaoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.MaterialResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiais")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/resumidos")
    public ResponseEntity<List<MaterialResumidoDTO>> obterTodosMateriais(){
        return ResponseEntity.status(HttpStatus.OK).body(materialService.obterTodosMateriais());
    }

    @GetMapping("/detalhado")
    public ResponseEntity<MaterialDetalhadoDTO> obterMaterial(@RequestParam String codigo){
        return ResponseEntity.status(HttpStatus.OK).body(materialService.obterMaterial(codigo));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ApiResponse> cadastrarMaterial(@RequestBody MaterialCadastroDTO materialCadastroDTO){
        ApiResponse response = materialService.cadastrarMaterial(materialCadastroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarMaterial(@PathVariable("id") Integer id, @RequestBody MaterialAtualizacaoDTO materialDto){
        ApiResponse response = materialService.atualizarMaterial(id, materialDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
