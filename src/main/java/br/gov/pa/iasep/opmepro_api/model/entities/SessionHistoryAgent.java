package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.SessionHistory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_sessao_agente")
@Getter
@Setter
public class SessionHistoryAgent extends SessionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_historico_sessao_agente", length = 11)
    private Integer code;

    @ManyToOne
    @JoinColumn(name = "cod_agente", nullable = false)
    private AgentUser agent;

    public SessionHistoryAgent(LocalDateTime loginDate, LocalDateTime logoutDate, String ipAddress, LocalDateTime updatedAt, Integer code, AgentUser agent) {
        super(loginDate, logoutDate, ipAddress, updatedAt);
        this.code = code;
        this.agent = agent;
    }

    public SessionHistoryAgent(LocalDateTime loginDate, LocalDateTime logoutDate, String ipAddress, LocalDateTime updatedAt, AgentUser agent) {
        super(loginDate, logoutDate, ipAddress, updatedAt);
        this.agent = agent;
    }

    public SessionHistoryAgent() {
    }
}
