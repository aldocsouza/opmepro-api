package br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs;

import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgentUserCreateDTO(

        @NotNull @NotBlank
        String name,

        @NotNull @NotBlank
        String cpf,

        @NotNull @NotBlank
        String registry,

        @NotNull @NotBlank
        String affiliation,

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
        UserRole role
) {
}
