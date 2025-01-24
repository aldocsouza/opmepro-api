package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.*;
import br.gov.pa.iasep.opmepro_api.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/resumidos")
    public ResponseEntity<List<UsuarioResumidoDTO>> obterUsuariosResumidos(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obterUsuariosResumidos());
    }

    @GetMapping("/resumido/{id}")
    public ResponseEntity<UsuarioResumidoDTO> obterUsuarioResumidoPorID(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obterUsuarioResumidoPorID(id));
    }

    @GetMapping("/detalhado/{id}")
    public ResponseEntity<UsuarioDetalhadoDTO> obterUsuarioDetalhado(@PathVariable("id") Integer id){
        UsuarioDetalhadoDTO response = usuarioService.obterUsuarioDetalhado(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/credenciado")
    public ResponseEntity<CredenciadoResumidoDTO> obterCredenciadoDeUsuario(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obterCredenciadoDeUsuario(id));
    }

    @GetMapping("/perfis")
    public ResponseEntity<List<UsuarioPerfilResumidoDTO>> obterPerfis(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obterPerfis());
    }

    @GetMapping("/situacao-usuario")
    public ResponseEntity<List<UsuarioSituacaoResumidoDTO>> obterSituacoesUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obterSituacoesUsuario());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarUsuario(@PathVariable("id") Integer id, @RequestBody UsuarioAtualizacaoDTO updateDTO){
        ApiResponse update = usuarioService.atualizarUsuario(id, updateDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
    }
}
