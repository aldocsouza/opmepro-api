package br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProcedimentoAtualizarDTO(
        Integer id,

        @NotNull @NotBlank
        String codigo,

        @NotNull @NotBlank
        String descricao,

        Double valor,

        @NotNull @NotBlank
        Integer usuarioAlteracao
) {
}
