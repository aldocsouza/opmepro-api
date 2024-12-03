package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "codificacao_material")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodificacaoMaterial {

    @EmbeddedId
    private CodificacaoMaterialId id;

    @ManyToOne
    @JoinColumn(name = "id_solicitacao", insertable = false, updatable = false)
    private Solicitacao solicitacao;

    @ManyToOne
    @JoinColumn(name = "id_material_opme", insertable = false, updatable = false)
    private Material material;

    @Column(name = "qtd_solicitado", nullable = false)
    private Integer qtdSolicitado;

    @Column(name = "qtd_autorizado")
    private Integer qtdAutorizado;

}
