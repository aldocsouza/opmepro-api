package br.gov.pa.iasep.copme_api.model.entities.DTOs;

import br.gov.pa.iasep.copme_api.model.enums.UserRole;

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
