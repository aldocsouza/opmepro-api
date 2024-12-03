package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseSolicitacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "solicitacao")
public class Solicitacao extends BaseSolicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_credenciado", nullable = false)
    private Credenciado credenciado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_segurado", nullable = false)
    private Segurado segurado;

    @OneToMany(mappedBy = "solicitacao")
    private List<Auditagem> auditagemList = new ArrayList<>();

    @OneToMany(mappedBy = "solicitacao")
    private List<DocumentoHash> documentoHashList = new ArrayList<>();

    @OneToMany(mappedBy = "solicitacao")
    private List<CodificacaoMaterial> codificacaoMaterialList = new ArrayList<>();

    @OneToMany(mappedBy = "solicitacao")
    private List<CodificacaoProcedimento> codificacaoProcedimentoList = new ArrayList<>();

    @OneToMany(mappedBy = "solicitacao")
    private List<SolicitacaoHistorico> solicitacaoHistoricoList = new ArrayList<>();

    public Solicitacao(Integer id, String medico, String observacao, Boolean status, LocalDateTime dataSolicitacao, String numProcesso, String termoAdesao, String grauParentesco, Credenciado credenciado, Usuario usuario, Segurado segurado, List<Auditagem> auditagemList, List<DocumentoHash> documentoHashList, List<CodificacaoMaterial> codificacaoMaterialList, List<CodificacaoProcedimento> codificacaoProcedimentoList, List<SolicitacaoHistorico> solicitacaoHistoricoList) {
        super(medico, observacao, status, dataSolicitacao, numProcesso, termoAdesao, grauParentesco);
        this.id = id;
        this.credenciado = credenciado;
        this.usuario = usuario;
        this.segurado = segurado;
    }

    public Solicitacao() {
    }
}
