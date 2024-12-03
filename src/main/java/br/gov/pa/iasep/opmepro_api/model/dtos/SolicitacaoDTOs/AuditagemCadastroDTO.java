package br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AuditagemCadastroDTO(
        @NotNull
        Integer idUsuario,

        @NotNull
        Integer idSolicitacao,

        @NotNull
        LocalDateTime dataAuditagem
) {
}
