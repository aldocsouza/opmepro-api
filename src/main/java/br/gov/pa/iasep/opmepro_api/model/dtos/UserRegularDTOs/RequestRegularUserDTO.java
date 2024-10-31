package br.gov.pa.iasep.opmepro_api.model.dtos.UserRegularDTOs;

import br.gov.pa.iasep.opmepro_api.model.entities.*;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record RequestRegularUserDTO(

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

        LocalDateTime lastSession,

        @NotNull
        Accredited accredited,

        List<SessionHistoryRegularUser> sessionHistoryRegularUsers,

        List<RegularUserFeature> regularUserFeatures
) {
}
