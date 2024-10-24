package br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs;

import jakarta.validation.constraints.NotNull;

public record RequestAgentFeatureDTO(

        @NotNull
        Integer featureCode,

        @NotNull
        Integer agentCode,

        @NotNull
        Boolean reading,

        @NotNull
        Boolean writing
) {
}
