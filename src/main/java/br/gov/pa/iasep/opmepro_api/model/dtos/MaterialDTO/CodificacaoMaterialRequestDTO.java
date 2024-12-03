package br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO;

import jakarta.validation.constraints.NotNull;

public record CodificacaoMaterialRequestDTO(

        @NotNull
        Integer idSolicitacao,

        @NotNull
        Integer idMateiral,

        @NotNull
        Integer qtdSolicitado,

        Integer qtdAutorizado
) {
}
