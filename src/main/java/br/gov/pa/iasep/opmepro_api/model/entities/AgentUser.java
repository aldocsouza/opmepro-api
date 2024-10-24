package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.User;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "agente")
@Getter
@Setter
public class AgentUser extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_agente", nullable = false, length = 11)
    private Integer code;

    @Column(name = "matricula", nullable = false, length = 20)
    private String registry;

    @Column(name = "vinculo", nullable = false, length = 2)
    private String affiliation;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<SessionHistoryAgent> sessionHistoryAgents = new ArrayList<>();

    @OneToMany(mappedBy = "agent")
    private List<AgentFeature> agentFeatures = new ArrayList<>();

    public AgentUser(
            String name, String cpf, String username, String password, String phone,
            String email, Boolean status, UserRole role, LocalDateTime lastSession,
            String registry, String affiliation
    ) {
        super(name, cpf, username, password, phone, email, status, role, lastSession);
        this.registry = registry;
        this.affiliation = affiliation;
    }

    public AgentUser(
            Integer code, String name, String cpf, String username, String password,
            String phone, String email, Boolean status, UserRole role, LocalDateTime lastSession,
            String registry, String affiliation
    ) {
        super(name, cpf, username, password, phone, email, status, role, lastSession);
        this.code = code;
        this.registry = registry;
        this.affiliation = affiliation;
    }

    public AgentUser() {
        super();
    }
}
