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
@RequestMapping("/api/usuario-funcionalidades")
public class UsuarioFuncionalidadeController {

    private final UsuarioFuncionalidadeService usuarioFuncionalidadeService;

    public UsuarioFuncionalidadeController(UsuarioFuncionalidadeService usuarioFuncionalidadeService) {
        this.usuarioFuncionalidadeService = usuarioFuncionalidadeService;
    }

    @GetMapping("/funcionalidades-usuario")
    public ResponseEntity<List<UsuarioPermissoesDTO>> getPermissoes(@RequestParam Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                usuarioFuncionalidadeService.getPermissoes(id)
        );
    }

    @PostMapping("/atribuir-funcionalidades")
    public ResponseEntity<ApiResponse> atribuirFuncionalidade(@RequestBody RequestUsuarioFuncionalidadeDTO[] usuarioFuncionalidade){
        for (RequestUsuarioFuncionalidadeDTO funcionalidade : usuarioFuncionalidade){
            usuarioFuncionalidadeService.atribuirFuncionalidade(funcionalidade);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ApiResponse("Cadastro realizado com sucesso!", true)
        );
    }
}
