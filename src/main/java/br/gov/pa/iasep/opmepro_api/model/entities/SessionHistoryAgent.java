package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.SessionHistory;
import jakarta.persistence.*;
import lombok.*;

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

    public SessionHistoryAgent(Integer code, AgentUser agent, LocalDateTime login_date, LocalDateTime logout_date, String ipAddress, LocalDateTime updatedAt) {
        super(login_date, logout_date, ipAddress, updatedAt);
        this.code = code;
        this.agent = agent;
    }

}
