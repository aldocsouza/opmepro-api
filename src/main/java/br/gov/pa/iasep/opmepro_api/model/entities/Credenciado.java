package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseCredenciado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "credenciado")
@Getter
@Setter
public class Credenciado extends BaseCredenciado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private CredenciadoTipo tipoCredenciado;

    @OneToMany(mappedBy = "credenciado")
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "credenciado")
    private List<CredenciadoHistorico> credenciadoHistoricoList = new ArrayList<>();

    @OneToMany(mappedBy = "credenciado")
    private List<Solicitacao> solicitacaoList = new ArrayList<>();


    public Credenciado(String matricula, String razaoSocial, String nomeFantasia, String cnpj, String cpf, String numContrato, Boolean status, String apelido, Integer id, CredenciadoTipo tipoCredenciado) {
        super(matricula, razaoSocial, nomeFantasia, cnpj, cpf, numContrato, status, apelido);
        this.id = id;
        this.tipoCredenciado = tipoCredenciado;
    }

    public Credenciado(String matricula, String razaoSocial, String nomeFantasia, String cnpj, String cpf, String numContrato, Boolean status, String apelido, CredenciadoTipo tipoCredenciado) {
        super(matricula, razaoSocial, nomeFantasia, cnpj, cpf, numContrato, status, apelido);
        this.tipoCredenciado = tipoCredenciado;
    }



    public Credenciado() {
    }
}
