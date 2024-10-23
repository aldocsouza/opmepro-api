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
    private AgentUser agentCode;

    public AgentFeature(AgentUser agentCode, Feature featureCode, Boolean reading, Boolean writing) {
        super(featureCode, reading, writing);
        this.agentCode = agentCode;
    }

    public AgentFeature() {
        super();
    }
}
