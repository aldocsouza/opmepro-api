package br.gov.pa.iasep.opmepro_api.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "featureCode", cascade = CascadeType.ALL, orphanRemoval = true)
    List<AgentFeature> agentFeatures = new ArrayList<>();

    @OneToMany(mappedBy = "featureCode", cascade = CascadeType.ALL, orphanRemoval = true)
    List<RegularUserFeature> regularUserFeatures = new ArrayList<>();
}
