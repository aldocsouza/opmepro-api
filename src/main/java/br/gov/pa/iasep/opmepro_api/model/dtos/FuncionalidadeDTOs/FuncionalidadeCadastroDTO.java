package br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionalidadeCadastroDTO (
        @NotNull @NotBlank
        String descricao
) {
}
