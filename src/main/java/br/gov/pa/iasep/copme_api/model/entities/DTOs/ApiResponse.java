package br.gov.pa.iasep.copme_api.model.entities.DTOs;

public record ApiResponse(
        String message,
        boolean success
) {
}
