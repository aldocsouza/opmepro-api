package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "codificacao_procedimento")
public class CodificacaoProcedimento {

    @EmbeddedId
    private CodificacaoProcedimentoId id;

    @ManyToOne
    @JoinColumn(name = "id_solicitacao", insertable = false, updatable = false)
    private Solicitacao solicitacao;

    @ManyToOne
    @JoinColumn(name = "id_procedimento", insertable = false, updatable = false)
    private Procedimento procedimento;

    @Column(name = "qtd_solicitado", nullable = false)
    private Integer qtdSolicitado;

    @Column(name = "qtd_autorizado")
    private Integer qtdAutorizado;

}
