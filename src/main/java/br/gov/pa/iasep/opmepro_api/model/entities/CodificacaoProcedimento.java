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
@IdClass(CodificacaoProcedimento.class)
public class CodificacaoProcedimento {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_solicitacao")
    private Solicitacao solicitacao;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_procedimento")
    private Procedimento procedimento;

    @Column(name = "qtd_solicitado", nullable = false)
    private Integer qtdSolicitado;

    @Column(name = "qtd_autorizado")
    private Integer qtdAutorizado;

}
