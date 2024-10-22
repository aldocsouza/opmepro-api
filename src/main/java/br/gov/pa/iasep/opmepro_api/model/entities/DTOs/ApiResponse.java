package br.gov.pa.iasep.opmepro_api.model.entities.DTOs;

public record ApiResponse(
        String message,
        boolean success
) {
}
