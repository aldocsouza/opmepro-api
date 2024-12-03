package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseSegurado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "segurado")
public class Segurado extends BaseSegurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "segurado")
    private List<Solicitacao> solicitacaoList = new ArrayList<>();

    @OneToMany(mappedBy = "segurado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeguradoHistorico> seguradoHistoricoList = new ArrayList<>();

    public Segurado(String nomeSegurado, String cpf, String sexo, Boolean status, String situacao, String municipio, String uf, Integer id, List<Solicitacao> solicitacaoList, List<SeguradoHistorico> seguradoHistoricoList) {
        super(nomeSegurado, cpf, sexo, status, situacao, municipio, uf);
        this.id = id;
        this.solicitacaoList = solicitacaoList;
        this.seguradoHistoricoList = seguradoHistoricoList;
    }

    public Segurado(String nomeSegurado, String cpf, String sexo, Boolean status, String situacao, String municipio, String uf, List<Solicitacao> solicitacaoList, List<SeguradoHistorico> seguradoHistoricoList) {
        super(nomeSegurado, cpf, sexo, status, situacao, municipio, uf);
        this.solicitacaoList = solicitacaoList;
        this.seguradoHistoricoList = seguradoHistoricoList;
    }

    public Segurado() {
        super();
    }
}
