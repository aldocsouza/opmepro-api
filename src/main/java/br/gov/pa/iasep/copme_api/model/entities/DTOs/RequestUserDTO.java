package br.gov.pa.iasep.copme_api.model.entities.DTOs;

import br.gov.pa.iasep.copme_api.model.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record RequestUserDTO(

        @NotNull
        String fullName,

        @NotNull
        String cpf,

        @NotNull
        String registration,

        @NotNull
        String email,

        @NotNull
        String phone,

        @NotNull
        String username,

        @NotNull
        String password,

        @NotNull
        Boolean situation,

        @NotNull
        UserRole role
) {
}
