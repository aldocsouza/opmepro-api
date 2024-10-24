package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcionalidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_funcionalidade", nullable = false)
    private Integer code;

    @Column(name = "descricao", nullable = false)
    private String description;

    @OneToMany(mappedBy = "feature", fetch = FetchType.LAZY)
    private List<AgentFeature> agentFeatures = new ArrayList<>();

    @OneToMany(mappedBy = "feature", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegularUserFeature> regularUserFeatures = new ArrayList<>();
}
