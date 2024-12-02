package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario extends BaseUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_credenciado", nullable = false)
    private Credenciado credenciado;

    @ManyToOne
    @JoinColumn(name = "id_perfil_usuario", nullable = false)
    private UsuarioPerfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_situacao_usuario", nullable = false)
    private UsuarioSituacao situacaoUsuario;

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

}
