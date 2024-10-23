package br.gov.pa.iasep.opmepro_api.model.dtos.UserAgentDTOs;

import br.gov.pa.iasep.opmepro_api.model.entities.AgentFeature;
import br.gov.pa.iasep.opmepro_api.model.entities.SessionHistoryAgent;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record RequestAgentDTO(

        @NotNull @NotBlank
        String name,

        @NotNull @NotBlank
        String cpf,

        @NotNull @NotBlank
        String registry,

        @NotNull @NotBlank
        String affiliation,

        @NotNull @NotBlank
        String username,

        @NotNull @NotBlank
        String password,

        @NotNull @NotBlank
        String phone,

        @NotNull @NotBlank
        String email,

        @NotNull
        Boolean status,

        @NotNull
        UserRole role,

        LocalDateTime lastSession,

        List<SessionHistoryAgent> sessionHistoryAgents,

        List<AgentFeature> agentFeatures
) {
}
