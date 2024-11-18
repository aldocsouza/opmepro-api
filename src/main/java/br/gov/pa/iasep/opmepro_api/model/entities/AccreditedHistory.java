package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseAccredited;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_credenciados")
@Getter
@Setter
@AllArgsConstructor
public class AccreditedHistory extends BaseAccredited {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_historico_credenciados", nullable = false)
    private Integer code;

    @Column(name = "cod_credenciados", nullable = false)
    private Integer accreditedCode;

    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime updatedAt;

    public AccreditedHistory(Integer code, Integer accreditedCode, String registry, String corporateName, String businessName, String cnpj, String contractNumber, String nickName, Boolean supplier, LocalDateTime updatedAt) {
        super(registry, corporateName, businessName, cnpj, contractNumber, nickName, supplier);
        this.code = code;
        this.accreditedCode = accreditedCode;
        this.updatedAt = updatedAt;
    }

    public AccreditedHistory() {
        super();
    }
}
