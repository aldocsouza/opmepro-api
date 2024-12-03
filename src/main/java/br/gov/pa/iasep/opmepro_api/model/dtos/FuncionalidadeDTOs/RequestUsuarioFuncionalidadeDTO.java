package br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs;

import jakarta.validation.constraints.NotNull;

public record RequestUsuarioFuncionalidadeDTO(
        @NotNull
        Integer idUsuario,

        @NotNull
        Integer idFuncionalidade,

        @NotNull
        Boolean leitura,

        @NotNull
        Boolean escrita
) {
}
