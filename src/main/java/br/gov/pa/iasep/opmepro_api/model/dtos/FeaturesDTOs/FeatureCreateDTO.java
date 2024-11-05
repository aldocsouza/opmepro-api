package br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FeatureCreateDTO(
        @NotNull @NotBlank String description
) {
}
