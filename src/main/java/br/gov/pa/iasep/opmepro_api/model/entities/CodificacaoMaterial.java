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
@IdClass(CodificacaoMaterialId.class)
public class CodificacaoMaterial {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_solicitacao")
    private Solicitacao solicitacao;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_material_opme")
    private Material material;

    @Column(name = "qtd_solicitado", nullable = false)
    private Integer qtdSolicitado;

    @Column(name = "qtd_autorizado")
    private Integer qtdAutorizado;

}
