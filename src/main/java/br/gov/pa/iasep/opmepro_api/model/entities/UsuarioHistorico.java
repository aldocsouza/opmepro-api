package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseUsuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_usuario")
@Getter
@Setter
public class UsuarioHistorico extends BaseUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    @Column(name = "usuario_alteracao")
    private Integer usuarioAlteracao;

    @Column(name = "id_perfil")
    private Integer perfil;

    @Column(name = "id_credenciado")
    private Integer credenciado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public UsuarioHistorico(String nome, String cpf, String username, String password, String telefone, String email,
                            Boolean situacao, Integer id, LocalDateTime dataAlteracao, Integer usuarioAlteracao,
                            Integer perfil, Integer credenciado, Usuario usuario
    ) {
        super(nome, cpf, username, password, telefone, email, situacao);
        this.id = id;
        this.dataAlteracao = dataAlteracao;
        this.usuarioAlteracao = usuarioAlteracao;
        this.perfil = perfil;
        this.credenciado = credenciado;
        this.usuario = usuario;
    }

    public UsuarioHistorico(String nome, String cpf, String username, String password, String telefone,
                            String email, Boolean situacao, LocalDateTime dataAlteracao, Integer usuarioAlteracao,
                            Integer perfil, Integer credenciado, Usuario usuario
    ) {
        super(nome, cpf, username, password, telefone, email, situacao);
        this.dataAlteracao = dataAlteracao;
        this.usuarioAlteracao = usuarioAlteracao;
        this.perfil = perfil;
        this.credenciado = credenciado;
        this.usuario = usuario;
    }
}
