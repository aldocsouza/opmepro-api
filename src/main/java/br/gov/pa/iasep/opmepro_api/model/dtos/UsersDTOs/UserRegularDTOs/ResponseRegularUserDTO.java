package br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.RequestUserAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.ResponseRegularFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SessionHistoryDTOs.ResponseSessionHistoryDTO;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseRegularUserDTO(
        Integer code,
        String name,
        String cpf,
        String username,
        String password,
        String phone,
        String email,
        Boolean status,
        UserRole role,
        LocalDateTime lastSession,
        RequestUserAccreditedDTO accredited,
        List<ResponseSessionHistoryDTO> sessionHistoryRegularUsers,
        List<ResponseRegularFeatureDTO> regularUserFeatures
) {
}
