package br.gov.pa.iasep.opmepro_api.controller;

import br.gov.pa.iasep.opmepro_api.services.SessionHistoryService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session")
public class SessionHistoryController {

    private final SessionHistoryService sessionHistoryService;

    public SessionHistoryController(SessionHistoryService sessionHistoryService) {
        this.sessionHistoryService = sessionHistoryService;
    }

    @PutMapping("/logout-agent")
    public void registryLogoutAgent(@RequestParam String logoutDate, Integer code){
        sessionHistoryService.endSessionHistoryAgent(logoutDate, code);
    }

    @PutMapping("/logout-regular")
    public void registryLogoutRegular(@RequestParam String logoutDate, Integer code){
        sessionHistoryService.endSessionHistoryRegular(logoutDate, code);
    }

}
