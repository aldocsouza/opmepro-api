package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseMaterial;
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
public class Material extends BaseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "material")
    private List<CodificacaoMaterial> codificacoes = new ArrayList<>();

    @OneToMany(mappedBy = "material")
    private List<MaterialHistorico> materialHistoricoList = new ArrayList<>();

}
