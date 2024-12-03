package br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record MaterialHistoricoDTO(
        Integer id,

        String codigo,

        String descricao,

        Double valor,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataAlteracao,

        Integer usuarioAlteracao
) {
}
