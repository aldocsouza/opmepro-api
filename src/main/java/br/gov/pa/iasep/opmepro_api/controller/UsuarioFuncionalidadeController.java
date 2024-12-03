package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.RequestUsuarioFuncionalidadeDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioPermissoesDTO;
import br.gov.pa.iasep.opmepro_api.services.UsuarioFuncionalidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-permissoes")
public class UsuarioFuncionalidadeController {

    private final UsuarioFuncionalidadeService usuarioFuncionalidadeService;

    public UsuarioFuncionalidadeController(UsuarioFuncionalidadeService usuarioFuncionalidadeService) {
        this.usuarioFuncionalidadeService = usuarioFuncionalidadeService;
    }

    @GetMapping("/permissoes")
    public ResponseEntity<List<UsuarioPermissoesDTO>> getPermissoes(@RequestParam Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                usuarioFuncionalidadeService.getPermissoes(id)
        );
    }

    @PostMapping("/atribuir-permissao")
    public ResponseEntity<ApiResponse> atribuirFuncionalidade(@RequestBody RequestUsuarioFuncionalidadeDTO[] userFeature){
        for (RequestUsuarioFuncionalidadeDTO feature : userFeature){
            usuarioFuncionalidadeService.atribuirFuncionalidade(feature);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ApiResponse("Cadastro realizado com sucesso!", true)
        );
    }
}
