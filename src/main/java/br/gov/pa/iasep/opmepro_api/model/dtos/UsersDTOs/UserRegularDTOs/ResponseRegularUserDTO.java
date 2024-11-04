package br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.RequestUserAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.ResponseRegularFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SessionHistoryDTOs.ResponseSessionHistoryDTO;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

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
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime lastSession,
        RequestUserAccreditedDTO accredited,
        List<ResponseSessionHistoryDTO> sessionHistoryRegularUsers,
        List<ResponseRegularFeatureDTO> regularUserFeatures
) {
}
