package br.gov.pa.iasep.opmepro_api.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestFeatureDTO (
        @NotNull @NotBlank String description
) {
}
