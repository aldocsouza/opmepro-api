package br.gov.pa.iasep.opmepro_api.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodificacaoProcedimentoId implements Serializable {

    private Integer idSolicitacao;
    private Integer idProcedimento;

}
