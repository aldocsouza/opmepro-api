package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioHistoricoSessao;
import br.gov.pa.iasep.opmepro_api.repositories.UserRepository;
import br.gov.pa.iasep.opmepro_api.repositories.SessionHistoryUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SessionHistoryService {

    private final SessionHistoryAgentRepository sessionHistoryAgentRepository;
    private final SessionHistoryUserRepository sessionHistoryUserRepository;
    private final AgentUserRepository agentUserRepository;
    private final UserRepository userRepository;

    public SessionHistoryService(
            SessionHistoryAgentRepository sessionHistoryAgentRepository,
            SessionHistoryUserRepository sessionHistoryUserRepository,
            AgentUserRepository agentUserRepository, UserRepository userRepository
    ) {
        this.sessionHistoryAgentRepository = sessionHistoryAgentRepository;
        this.sessionHistoryUserRepository = sessionHistoryUserRepository;
        this.agentUserRepository = agentUserRepository;
        this.userRepository = userRepository;
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
        sessionHistoryAgent.setLogoutDate(logout);

        sessionHistoryAgentRepository.save(sessionHistoryAgent);
    }

    public void startSessionHistoryRegular(RegularUser regularUser, String ipClient){
        UsuarioHistoricoSessao historyRegularUser = new UsuarioHistoricoSessao(
                LocalDateTime.now(),
                null,
                ipClient,
                null,
                regularUser
        );
        sessionHistoryUserRepository.save(historyRegularUser);
    }

    public void endSessionHistoryRegular(String logoutDate, Integer code){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        ZonedDateTime utcDateTime = ZonedDateTime.parse(logoutDate, formatter);
        LocalDateTime logout = utcDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();

        RegularUser regularUser = userRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        UsuarioHistoricoSessao usuarioHistoricoSessao = sessionHistoryUserRepository.findTopByRegularUserOrderByLoginDateDesc(regularUser);
        usuarioHistoricoSessao.setLogoutDate(logout);

        sessionHistoryUserRepository.save(usuarioHistoricoSessao);
    }

}
