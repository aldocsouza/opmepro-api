package br.gov.pa.iasep.opmepro_api.base;

import br.gov.pa.iasep.opmepro_api.model.entities.CredenciadoTipo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public abstract class BaseCredenciado {

    @Column(name = "matricula", nullable = false, length = 45)
    private String matricula;

    @Column(name = "razao_social", nullable = false, length = 120)
    private String razaoSocial;

    @Column(name = "nome_fantasia", nullable = false, length = 120)
    private String nomeFantasia;

    @Column(name = "cnpj", nullable = false, length = 18)
    private String cnpj;

    @Column(name = "num_contrato", nullable = false, length = 45)
    private String numContrato;

    @Column(name = "apelido", length = 50)
    private String apelido;

}
