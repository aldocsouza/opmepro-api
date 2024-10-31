package br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserNoListDTO;

import java.util.List;

public record ResponseAccreditedAndUsersDTO(
        Integer code,
        String registry,
        String corporateName,
        String businessName,
        String cnpj,
        String contractNumber,
        String nickName,
        Boolean supplier,
        List<ResponseRegularUserNoListDTO> regularUsers
) {
}
