package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseCredenciado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_credenciados")
@Getter
@Setter
public class CredenciadoHistorico extends BaseCredenciado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime dataAlteracao;

    @Column(name = "usuario_alteracao", nullable = false)
    private Integer usuarioAlteracao;

    @Column(name = "id_tipo", nullable = false)
    private Integer tipoCredenciado;

    @ManyToOne
    @JoinColumn(name = "id_credenciado", nullable = false)
    private Credenciado credenciado;

    public CredenciadoHistorico(String matricula, String razaoSocial, String nomeFantasia, String cnpj, String cpf, String numContrato, Boolean status, String apelido, Integer id, LocalDateTime dataAlteracao, Integer usuarioAlteracao, Integer tipoCredenciado, Credenciado credenciado) {
        super(matricula, razaoSocial, nomeFantasia, cnpj, cpf, numContrato, status, apelido);
        this.id = id;
        this.dataAlteracao = dataAlteracao;
        this.usuarioAlteracao = usuarioAlteracao;
        this.tipoCredenciado = tipoCredenciado;
        this.credenciado = credenciado;
    }

    public CredenciadoHistorico(String matricula, String razaoSocial, String nomeFantasia, String cnpj, String cpf, String numContrato, Boolean status, String apelido, LocalDateTime dataAlteracao, Integer usuarioAlteracao, Integer tipoCredenciado, Credenciado credenciado) {
        super(matricula, razaoSocial, nomeFantasia, cnpj, cpf, numContrato, status, apelido);
        this.dataAlteracao = dataAlteracao;
        this.usuarioAlteracao = usuarioAlteracao;
        this.tipoCredenciado = tipoCredenciado;
        this.credenciado = credenciado;
    }

    public CredenciadoHistorico() {
    }
}
