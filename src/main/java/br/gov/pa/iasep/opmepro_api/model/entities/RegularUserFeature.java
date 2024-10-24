package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.UserFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_funcionalidade")
@Getter
@Setter
@IdClass(RegularUserFeatureId.class)
public class RegularUserFeature extends UserFeature {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_cod_usuario", nullable = false)
    private RegularUser regularUser;

    public RegularUserFeature(RegularUser regularUser, Feature featureCode, Boolean reading, Boolean writing) {
        super(featureCode, reading, writing);
        this.regularUser = regularUser;
    }

    public RegularUserFeature() {
        super();
    }
}
