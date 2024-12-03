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
public abstract class BaseMaterial {

    @Column(name = "codigo")
    protected String codigo;

    @Column(name = "dsc_material", nullable = false)
    protected String descricao;

    @Column(name = "valor")
    protected Double valor;

}
