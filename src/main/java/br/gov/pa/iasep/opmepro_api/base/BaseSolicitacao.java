package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseSolicitacao {

    @Column(name = "medico", nullable = false)
    private String medico;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "data_solicitacao", nullable = false)
    private LocalDateTime dataSolicitacao;

    @Column(name = "num_processo", nullable = false)
    private String numProcesso;

    @Column(name = "termo_adesao", nullable = false)
    private String termoAdesao;

    @Column(name = "grau_parentesco", nullable = false)
    private String grauParentesco;

}
