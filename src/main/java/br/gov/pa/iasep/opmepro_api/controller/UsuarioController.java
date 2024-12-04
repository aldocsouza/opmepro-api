package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioAtualizacaoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioComFuncionalidadesDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDetalhadoDTO>> getUsuarios(){
        List<UsuarioDetalhadoDTO> response = usuarioService.getUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/usuario-funcionalidades")
    public ResponseEntity<List<UsuarioComFuncionalidadesDTO>> fetchUsuariosComFuncionalidades(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.fetchUsuariosComFuncionalidades());
    }

    @GetMapping("/usuario-basico")
    public ResponseEntity<List<UsuarioResumidoDTO>> fetchUsuariosBasicos(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.fetchUsuariosBasicos());
    }

    @GetMapping("/usuario-credenciado")
    public ResponseEntity<CredenciadoResumidoDTO> getCredenciadoDeUsuario(@RequestParam Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getCredenciadoDeUsuario(id));
    }

    @PutMapping("/atualizar-usuario")
    public ResponseEntity<ApiResponse> atualizarUsuario(@RequestBody UsuarioAtualizacaoDTO updateDTO){
        ApiResponse update = usuarioService.atualizarUsuario(updateDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
    }
}
