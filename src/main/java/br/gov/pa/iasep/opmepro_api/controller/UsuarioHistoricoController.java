package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.services.HistoricoSessaoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sessao")
public class UsuarioHistoricoController {

    private final HistoricoSessaoService historicoSessaoService;

    public UsuarioHistoricoController(HistoricoSessaoService historicoSessaoService) {
        this.historicoSessaoService = historicoSessaoService;
    }

    @PutMapping("/logout-usuario")
    public void registrarLogout(@RequestParam String logoutDate, Integer code){
        historicoSessaoService.registrarLogout(logoutDate, code);
    }

}
