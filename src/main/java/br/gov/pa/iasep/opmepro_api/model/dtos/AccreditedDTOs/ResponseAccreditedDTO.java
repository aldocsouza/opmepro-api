package br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UserRegularDTOs.ResponseRegularUserDTO;

import java.util.List;

public record ResponseAccreditedDTO(

        Integer code,
        String registry,
        String corporateName,
        String businessName,
        String cnpj,
        String contractNumber,
        String nickName,
        Boolean supplier,
        List<ResponseRegularUserDTO> regularUsersDTO
) {
}
