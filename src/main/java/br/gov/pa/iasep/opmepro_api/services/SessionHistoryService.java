package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import br.gov.pa.iasep.opmepro_api.model.entities.SessionHistoryAgent;
import br.gov.pa.iasep.opmepro_api.model.entities.SessionHistoryRegularUser;
import br.gov.pa.iasep.opmepro_api.repositories.SessionHistoryAgentRepository;
import br.gov.pa.iasep.opmepro_api.repositories.SessionHistoryRegularRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionHistoryService {

    private final SessionHistoryAgentRepository sessionHistoryAgentRepository;
    private final SessionHistoryRegularRepository sessionHistoryRegularRepository;

    public SessionHistoryService(SessionHistoryAgentRepository sessionHistoryAgentRepository, SessionHistoryRegularRepository sessionHistoryRegularRepository) {
        this.sessionHistoryAgentRepository = sessionHistoryAgentRepository;
        this.sessionHistoryRegularRepository = sessionHistoryRegularRepository;
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

}
