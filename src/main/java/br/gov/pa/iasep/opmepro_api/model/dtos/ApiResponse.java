package br.gov.pa.iasep.opmepro_api.model.dtos;

public record ApiResponse(
        String message,
        boolean success
) {
}
