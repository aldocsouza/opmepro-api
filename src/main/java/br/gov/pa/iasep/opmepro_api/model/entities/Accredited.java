package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseAccredited;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "credenciados")
@Getter
@Setter
@AllArgsConstructor
public class Accredited extends BaseAccredited {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_credenciados", nullable = false)
    private Integer code;

    public Accredited(String registry, String corporateName, String businessName, String cnpj, String contractNumber, String nickName, Boolean isSupplier, Integer code) {
        super(registry, corporateName, businessName, cnpj, contractNumber, nickName, isSupplier);
        this.code = code;
    }

    public Accredited() {
        super();
    }
}
