package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import br.gov.pa.iasep.opmepro_api.model.entities.SessionHistoryAgent;
import br.gov.pa.iasep.opmepro_api.model.entities.SessionHistoryRegularUser;
import br.gov.pa.iasep.opmepro_api.repositories.AgentUserRepository;
import br.gov.pa.iasep.opmepro_api.repositories.RegularUserRepository;
import br.gov.pa.iasep.opmepro_api.repositories.SessionHistoryAgentRepository;
import br.gov.pa.iasep.opmepro_api.repositories.SessionHistoryRegularRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SessionHistoryService {

    private final SessionHistoryAgentRepository sessionHistoryAgentRepository;
    private final SessionHistoryRegularRepository sessionHistoryRegularRepository;
    private final AgentUserRepository agentUserRepository;
    private final RegularUserRepository regularUserRepository;

    public SessionHistoryService(
            SessionHistoryAgentRepository sessionHistoryAgentRepository,
            SessionHistoryRegularRepository sessionHistoryRegularRepository,
            AgentUserRepository agentUserRepository, RegularUserRepository regularUserRepository
    ) {
        this.sessionHistoryAgentRepository = sessionHistoryAgentRepository;
        this.sessionHistoryRegularRepository = sessionHistoryRegularRepository;
        this.agentUserRepository = agentUserRepository;
        this.regularUserRepository = regularUserRepository;
    }

    public void startSessionHistoryAgent(AgentUser agentUser, String ipClient){
        SessionHistoryAgent sessionHistoryAgent = new SessionHistoryAgent(
                LocalDateTime.now(),
                null,
                ipClient,
                null,
                agentUser
        );
        sessionHistoryAgentRepository.save(sessionHistoryAgent);
    }

    public void endSessionHistoryAgent(String logoutDate, Integer code){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        ZonedDateTime utcDateTime = ZonedDateTime.parse(logoutDate, formatter);
        LocalDateTime logout = utcDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();

        AgentUser agentUser = agentUserRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        SessionHistoryAgent sessionHistoryAgent = sessionHistoryAgentRepository.findTopByAgentOrderByLoginDateDesc(agentUser);
        System.out.println(sessionHistoryAgent.getCode());
        sessionHistoryAgent.setLogoutDate(logout);

        sessionHistoryAgentRepository.save(sessionHistoryAgent);
    }

    public void startSessionHistoryRegular(RegularUser regularUser, String ipClient){
        SessionHistoryRegularUser historyRegularUser = new SessionHistoryRegularUser(
                LocalDateTime.now(),
                null,
                ipClient,
                null,
                regularUser
        );
        sessionHistoryRegularRepository.save(historyRegularUser);
    }

    public void endSessionHistoryRegular(String logoutDate, Integer code){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        ZonedDateTime utcDateTime = ZonedDateTime.parse(logoutDate, formatter);
        LocalDateTime logout = utcDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();

        RegularUser regularUser = regularUserRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        SessionHistoryRegularUser sessionHistoryRegularUser = sessionHistoryRegularRepository.findTopByRegularUserOrderByLoginDateDesc(regularUser);
        sessionHistoryRegularUser.setLogoutDate(logout);

        sessionHistoryRegularRepository.save(sessionHistoryRegularUser);
    }

}
