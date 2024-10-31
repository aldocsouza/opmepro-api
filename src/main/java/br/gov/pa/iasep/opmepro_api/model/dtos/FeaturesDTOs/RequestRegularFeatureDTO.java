package br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs;

import jakarta.validation.constraints.NotNull;

public record RequestRegularFeatureDTO (
        @NotNull
        Integer featureCode,

        @NotNull
        Integer userCode,

        @NotNull
        Boolean reading,

        @NotNull
        Boolean writing
){
}
