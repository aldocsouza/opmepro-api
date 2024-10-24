package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.UserFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agente_funcionalidade")
@Getter
@Setter
@IdClass(AgentFeatureId.class)
public class AgentFeature extends UserFeature {

    @Id
    @ManyToOne
    @JoinColumn(name = "agente_cod_agente", nullable = false)
    private AgentUser agent;

    public AgentFeature(AgentUser agent, Feature feature, Boolean reading, Boolean writing) {
        super(feature, reading, writing);
        this.agent = agent;
    }

    public AgentFeature() {
        super();
    }
}
