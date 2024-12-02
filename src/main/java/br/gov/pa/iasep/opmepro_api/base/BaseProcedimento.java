package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseProcedimento {

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "dsc_procedimento", nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private Double valor;

}
