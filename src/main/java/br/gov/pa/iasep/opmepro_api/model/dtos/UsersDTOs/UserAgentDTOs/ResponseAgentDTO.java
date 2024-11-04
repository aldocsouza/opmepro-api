package br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.ResponseAgentFeatureDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SessionHistoryDTOs.ResponseSessionHistoryDTO;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseAgentDTO(
        Integer code,
        String name,
        String cpf,
        String registry,
        String affiliation,
        String username,
        String password,
        String phone,
        String email,
        Boolean status,
        UserRole role,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime lastSession,
        List<ResponseAgentFeatureDTO> agentFeatures,
        List<ResponseSessionHistoryDTO> sessionHistoryAgents
) {
}
