package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class SessionHistory {

    @Column(name = "data_login", nullable = false)
    private LocalDateTime login_date;

    @Column(name = "data_logout", nullable = false)
    private LocalDateTime logout_date;

    @Column(name = "endereco_ip", nullable = false, length = 15)
    private String ipAddress;

    @Column(name = "data_alteracao", nullable = false, length = 15)
    private LocalDateTime updatedAt;

    public SessionHistory(LocalDateTime login_date, LocalDateTime logout_date, String ipAddress, LocalDateTime updatedAt) {
        this.login_date = login_date;
        this.logout_date = logout_date;
        this.ipAddress = ipAddress;
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getLogin_date() {
        return login_date;
    }

    public void setLogin_date(LocalDateTime login_date) {
        this.login_date = login_date;
    }

    public LocalDateTime getLogout_date() {
        return logout_date;
    }

    public void setLogout_date(LocalDateTime logout_date) {
        this.logout_date = logout_date;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
