package br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoResumidoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SeguradoHistoricoResumidoDTO (
        Integer id,
        String nomeSegurado,
        String cpf,
        String termoAdesao,
        String sexo,
        Boolean status,
        String situacao,
        String municipio,
        String uf,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataAlteracao,
        Integer usuarioAlteracao,
        SeguradoResumidoDTO segurado
) {
}
