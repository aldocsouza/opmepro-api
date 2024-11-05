package br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs;

public record FeatureAndUsersDTO(
        ResponseFeatureDTO feature,
        Boolean reading,
        Boolean writing
) {
}
