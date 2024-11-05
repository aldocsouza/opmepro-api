package br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserAccreditedCreateDTO(
        @NotNull @NotBlank
        Integer code,

        @NotNull @NotBlank
        String registry,

        @NotNull @NotBlank
        String corporateName,

        @NotNull @NotBlank
        String businessName,

        @NotNull @NotBlank
        String cnpj,

        @NotNull @NotBlank
        String contractNumber,

        @NotNull @NotBlank
        String nickName,

        @NotNull
        Boolean supplier
) {
}
