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
public abstract class BaseSegurado {

    @Column(name = "nome_segurado", nullable = false)
    private String nomeSegurado;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "ind_sexo")
    private String sexo;

    @Column(name = "ind_status")
    private Boolean status;

    @Column(name = "nom_situacao", nullable = false)
    private String situacao;

    @Column(name = "nom_municipio", nullable = false)
    private String municipio;

    @Column(name = "uf")
    private String uf;

}
