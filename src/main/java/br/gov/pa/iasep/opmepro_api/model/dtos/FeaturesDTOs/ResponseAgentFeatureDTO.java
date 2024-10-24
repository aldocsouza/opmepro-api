package br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs;

import jakarta.validation.constraints.NotNull;

public record ResponseAgentFeatureDTO(

        @NotNull
        ResponseFeatureDTO feature,

        @NotNull
        Boolean reading,

        @NotNull
        Boolean writing
) {
}
