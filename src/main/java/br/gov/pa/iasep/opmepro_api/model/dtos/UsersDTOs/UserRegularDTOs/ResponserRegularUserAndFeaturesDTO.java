package br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.ResponseAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.FeatureAndUsersDTO;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record ResponserRegularUserAndFeaturesDTO(
        Integer code,
        String name,
        String cpf,
        String username,
        String phone,
        String email,
        Boolean status,
        UserRole role,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime lastSession,
        ResponseAccreditedDTO accredited,
        List<FeatureAndUsersDTO> regularUserFeatures
) {
}