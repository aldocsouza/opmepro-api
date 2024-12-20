package br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SolicitacaoHistoricoResumidoDTO(
        Integer id,

        String medico,

        String observacao,

        Boolean status,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataSolicitacao,

        String numProcesso,

        String termoAdesao,

        String grauParentesco,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataAlteracao,

        Integer usuarioAlteracao,

        Integer idCredenciado,

        Integer idSegurado
) {
}
