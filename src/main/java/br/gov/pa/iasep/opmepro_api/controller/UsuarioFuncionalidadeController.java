package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.RequestUsuarioFuncionalidadeDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioFuncionalidadeResponseUsuarioDTO;
import br.gov.pa.iasep.opmepro_api.services.UsuarioFuncionalidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios-funcionalidades")
public class UsuarioFuncionalidadeController {

    private final UsuarioFuncionalidadeService usuarioFuncionalidadeService;

    public UsuarioFuncionalidadeController(UsuarioFuncionalidadeService usuarioFuncionalidadeService) {
        this.usuarioFuncionalidadeService = usuarioFuncionalidadeService;
    }

    @GetMapping("/{id}/funcionalidades")
    public ResponseEntity<List<UsuarioFuncionalidadeResponseUsuarioDTO>> obterFuncionalidades(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioFuncionalidadeService.getPermissoes(id));
    }

    @PostMapping("/atribuir")
    public ResponseEntity<ApiResponse> atribuirFuncionalidade(@RequestBody List<RequestUsuarioFuncionalidadeDTO> usuarioFuncionalidade){
        ApiResponse response = usuarioFuncionalidadeService.atribuirFuncionalidade(usuarioFuncionalidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
