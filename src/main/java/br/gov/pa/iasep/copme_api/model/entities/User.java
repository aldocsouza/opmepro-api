package br.gov.pa.iasep.copme_api.model.entities;

import br.gov.pa.iasep.copme_api.model.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tab_usuario")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome_completo", nullable = false)
    private String fullName;

    @NotNull
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @NotNull
    @Column(name = "matricula", nullable = false)
    private String registration;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "telefone", nullable = false)
    private String phone;

    @NotNull
    @Column(name = "login", nullable = false)
    private String username;

    @NotNull
    @Column(name = "senha_hash", nullable = false)
    private String password;

    @NotNull
    @Column(name = "situacao", nullable = false)
    private Boolean situation;

    @NotNull
    @Column(name = "perfil", nullable = false)
    private UserRole role;

    public User(
            String fullName, String cpf, String registration, String email,
            String phone, String username, String password, Boolean situation,
            UserRole role
    ) {
        this.fullName = fullName;
        this.cpf = cpf;
        this.registration = registration;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.situation = situation;
        this.role = role;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public @NotNull String getFullName() {
        return fullName;
    }

    public void setFullName(@NotNull String fullName) {
        this.fullName = fullName;
    }

    public @NotNull String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull String cpf) {
        this.cpf = cpf;
    }

    public @NotNull String getRegistration() {
        return registration;
    }

    public void setRegistration(@NotNull String registration) {
        this.registration = registration;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NotNull String getPhone() {
        return phone;
    }

    public void setPhone(@NotNull String phone) {
        this.phone = phone;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public @NotNull Boolean getSituation() {
        return situation;
    }

    public void setSituation(@NotNull Boolean situation) {
        this.situation = situation;
    }

    public @NotNull UserRole getRole() {
        return role;
    }

    public void setRole(@NotNull UserRole role) {
        this.role = role;
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
