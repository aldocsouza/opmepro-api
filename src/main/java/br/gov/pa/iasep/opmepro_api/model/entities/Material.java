package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "material_opme")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_material_opme")
    private Integer id;

    @Column(name = "codigo")
    private String code;

    @Column(name = "dsc_material", nullable = false)
    private String description;

    @Column(name = "valor")
    private Double value;

    @ManyToMany(mappedBy = "materials")
    private List<Accredited> accrediteds = new ArrayList<>();

    @OneToMany(mappedBy = "material")
    private List<MaterialHistory> materialHistories = new ArrayList<>();
}
