package br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MaterialAtualizacaoDTO(
        Integer id,

        String codigo,

        @NotNull @NotBlank
        String descricao,

        Double valor,

        @NotNull @NotBlank
        Integer usuarioAlteracao
) {
}
