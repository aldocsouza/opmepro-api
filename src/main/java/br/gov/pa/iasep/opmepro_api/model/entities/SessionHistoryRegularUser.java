package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.SessionHistory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_sessao_usuario")
@Getter
@Setter
public class SessionHistoryRegularUser extends SessionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_historico_sessao_usuario", length = 11)
    private Integer code;

    @ManyToOne
    @JoinColumn(name = "cod_usuario", nullable = false)
    private RegularUser regularUser;

    public SessionHistoryRegularUser(LocalDateTime login_date, LocalDateTime logout_date, String ipAddress, LocalDateTime updatedAt, Integer code, RegularUser regularUser) {
        super(login_date, logout_date, ipAddress, updatedAt);
        this.code = code;
        this.regularUser = regularUser;
    }
}
