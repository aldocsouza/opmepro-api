package br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.UserAccreditedCreateDTO;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegularUserCreateDTO(

        @NotNull @NotBlank
        String name,

        @NotNull @NotBlank
        String cpf,

        @NotNull @NotBlank
        String username,

        @NotNull @NotBlank
        String password,

        @NotNull @NotBlank
        String phone,

        @NotNull @NotBlank
        String email,

        @NotNull
        Boolean status,

        @NotNull
        UserRole role,

        @NotNull
        UserAccreditedCreateDTO accredited
) {
}
