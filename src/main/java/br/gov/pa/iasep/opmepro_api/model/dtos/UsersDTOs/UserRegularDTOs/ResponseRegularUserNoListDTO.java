package br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs;

import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;

import java.time.LocalDateTime;

public record ResponseRegularUserNoListDTO (
        Integer code,
        String name,
        String cpf,
        String username,
        String phone,
        String email,
        Boolean status,
        UserRole role,
        LocalDateTime lastSession
) {
}
