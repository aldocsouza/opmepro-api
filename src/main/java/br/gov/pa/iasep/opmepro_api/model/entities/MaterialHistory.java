package br.gov.pa.iasep.opmepro_api.model.entities;

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
public class MaterialHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_historico_material_opme")
    private Integer id;

    @Column(name = "codigo")
    private String code;

    @Column(name = "dsc_material", nullable = false)
    private String description;

    @Column(name = "valor")
    private Double value;

    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime modificationDate;
}
