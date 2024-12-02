package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseProcedimento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "procedimentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Procedimento extends BaseProcedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_procedimentos")
    private Integer id;

    @OneToMany(mappedBy = "procedimento")
    private List<CodificacaoProcedimento> codificacoes = new ArrayList<>();

    @OneToMany(mappedBy = "procedimento")
    private List<ProcedimentoHistorico> procedimentoHistoricoList = new ArrayList<>();

}
