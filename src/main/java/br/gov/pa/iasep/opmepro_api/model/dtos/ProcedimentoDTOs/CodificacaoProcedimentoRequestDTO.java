package br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs;

import jakarta.validation.constraints.NotNull;

public record CodificacaoProcedimentoRequestDTO(

        @NotNull
        Integer idSolicitacao,

        @NotNull
        Integer idProcedimento,

        @NotNull
        Integer qtdSolicitado,

        Integer qtdAutorizado
) {
}
