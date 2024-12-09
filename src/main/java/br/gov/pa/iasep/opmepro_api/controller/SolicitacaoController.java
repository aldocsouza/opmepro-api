package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoDetalhadaDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.services.SolicitacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacaoController {

    private final SolicitacaoService solicitacaoService;

    public SolicitacaoController(SolicitacaoService solicitacaoService) {
        this.solicitacaoService = solicitacaoService;
    }

    @GetMapping("/resumidas")
    public ResponseEntity<List<SolicitacaoResumidoDTO>> obterSolicitacoesResumidas(){
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoService.obterSolicitacoesResumidas());
    }

    @GetMapping("/{id}/detalhado")
    public ResponseEntity<SolicitacaoDetalhadaDTO> obterSolicitacaoDetalhada(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoService.obterSolicitacaoDetalhada(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity<ApiResponse> registrarSolicitacao(@RequestBody SolicitacaoCadastroDTO solicitacaoCadastroDTO) {
        ApiResponse response = solicitacaoService.registrarSolicitacao(solicitacaoCadastroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
