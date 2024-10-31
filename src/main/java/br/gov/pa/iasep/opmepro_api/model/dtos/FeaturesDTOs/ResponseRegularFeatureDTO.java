package br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs;

public record ResponseRegularFeatureDTO(
        ResponseFeatureDTO feature,
        Boolean reading,
        Boolean writing
) {
}
