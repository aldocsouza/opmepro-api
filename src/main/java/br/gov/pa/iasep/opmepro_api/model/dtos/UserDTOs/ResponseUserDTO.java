package br.gov.pa.iasep.opmepro_api.model.dtos.UserDTOs;

import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;

public record ResponseUserDTO(
        Long id,
        String fullName,
        String cpf,
        String registration,
        String email,
        String phone,
        String username,
        String password,
        Boolean situation,
        UserRole role
) {
}
