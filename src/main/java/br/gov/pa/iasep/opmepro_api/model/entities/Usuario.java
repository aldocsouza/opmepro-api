package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseUsuario;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario extends BaseUsuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relacionamentos Muitos pra Um
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_credenciado")
    private Credenciado credenciado;

    @ManyToOne
    @JoinColumn(name = "id_perfil_usuario", nullable = false)
    private UsuarioPerfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_situacao_usuario", nullable = false)
    private UsuarioSituacao situacaoUsuario;

    // Relacionamentos Um pra Muitos
    @OneToMany(mappedBy = "usuario")
    private List<UsuarioFuncionalidade> usuarioFuncionalidadeList = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioHistoricoSessao> usuarioHistoricoSessaoList = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioHistorico> usuarioHistoricoList = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Solicitacao> solicitacaoList = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Auditagem> auditagemList = new ArrayList<>();

    public Usuario(String nome, String cpf, String username, String password, String telefone, String email, Boolean situacao,
                   Integer id, Credenciado credenciado, UsuarioPerfil perfil, UsuarioSituacao situacaoUsuario) {
        super(nome, cpf, username, password, telefone, email, situacao);
        this.id = id;
        this.credenciado = credenciado;
        this.perfil = perfil;
        this.situacaoUsuario = situacaoUsuario;
    }

    public Usuario(String nome, String cpf, String username, String password, String telefone, String email, Boolean situacao, Credenciado credenciado, UsuarioPerfil perfil, UsuarioSituacao situacaoUsuario) {
        super(nome, cpf, username, password, telefone, email, situacao);
        this.credenciado = credenciado;
        this.perfil = perfil;
        this.situacaoUsuario = situacaoUsuario;
    }

    public Usuario() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.perfil.equals(UserRole.ADMINISTRADOR)) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
