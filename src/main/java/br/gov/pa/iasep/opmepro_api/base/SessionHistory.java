package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class SessionHistory {

    @Column(name = "data_login", nullable = false)
    private LocalDateTime loginDate;

    @Column(name = "data_logout", nullable = false)
    private LocalDateTime logoutDate;

    @Column(name = "endereco_ip", nullable = false, length = 15)
    private String ipAddress;

    @Column(name = "data_alteracao", nullable = false, length = 15)
    private LocalDateTime updatedAt;

    public SessionHistory(LocalDateTime loginDate, LocalDateTime logout_date, String ipAddress, LocalDateTime updatedAt) {
        this.loginDate = loginDate;
        this.logoutDate = logoutDate;
        this.ipAddress = ipAddress;
        this.updatedAt = updatedAt;
    }
}
