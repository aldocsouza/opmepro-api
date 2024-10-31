package br.gov.pa.iasep.opmepro_api.model.dtos.SessionHistoryDTOs;

import java.time.LocalDateTime;

public record ResponseSessionHistoryDTO(
        LocalDateTime loginDate,
        String ipAddress,
        LocalDateTime logoutDate,
        LocalDateTime updatedAt
) {
}
