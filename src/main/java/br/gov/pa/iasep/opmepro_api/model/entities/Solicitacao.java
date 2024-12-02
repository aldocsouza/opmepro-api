package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseSolicitacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "solicitacao")
@AllArgsConstructor
@NoArgsConstructor
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

}
