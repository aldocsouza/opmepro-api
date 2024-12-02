package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseMaterial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_material_opme")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialHistorico extends BaseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime dataAlteracao;

    @Column(name = "usuario_alteracao", nullable = false)
    private Integer usuarioAlteracao;

    @ManyToOne
    @JoinColumn(name = "id_material_opme", nullable = false)
    private Material material;
}
