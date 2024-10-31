package br.gov.pa.iasep.opmepro_api.base;

import br.gov.pa.iasep.opmepro_api.model.entities.AgentFeature;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import br.gov.pa.iasep.opmepro_api.model.entities.SessionHistoryAgent;
import br.gov.pa.iasep.opmepro_api.model.entities.SessionHistoryRegularUser;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@MappedSuperclass
public abstract class User implements UserDetails {

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "login", nullable = false, length = 20)
    private String username;

    @Column(name = "senha", nullable = false, length = 100)
    private String password;

    @Column(name = "telefone", nullable = false, length = 11)
    private String phone;

    @Column(name = "email", nullable = false, length = 155)
    private String email;

    @Column(name = "situacao", nullable = false)
    private Boolean status;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil_usuario_cod_perfil", nullable = false)
    private UserRole role;

    @Column(name = "ultima_sessao")
    private LocalDateTime lastSession;

    @OneToMany(mappedBy = "cod_usuario", cascade = CascadeType.ALL)
    private List<SessionHistoryRegularUser> sessionHistoryRegularUserList = new ArrayList<>();

    @OneToMany(mappedBy = "cod_usuario")
    private List<RegularUser> regularUsers = new ArrayList<>();

    public User(String name, String cpf, String username, String password, String phone, String email, Boolean status, UserRole role, LocalDateTime lastSession) {
        this.name = name;
        this.cpf = cpf;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.role = role;
        this.lastSession = lastSession;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getLastSession() {
        return lastSession;
    }

    public void setLastSession(LocalDateTime lastSession) {
        this.lastSession = lastSession;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role.equals(UserRole.ADMIN)) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
