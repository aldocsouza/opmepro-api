package br.gov.pa.iasep.opmepro_api.model.dtos.SessionHistoryDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.ResponseAgentNoListDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RequestSessionHistoryAgentDTO(
        @NotNull
        ResponseAgentNoListDTO agentUser,

        @NotNull
        LocalDateTime loginDate,

        @NotNull
        String ipAddress,

        @NotNull
        LocalDateTime logoutDate,

        @NotNull
        LocalDateTime updatedAt
) {
}
