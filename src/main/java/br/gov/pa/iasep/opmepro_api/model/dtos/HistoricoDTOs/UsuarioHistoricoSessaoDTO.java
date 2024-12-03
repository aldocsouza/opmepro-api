package br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UsuarioHistoricoSessaoDTO (
        Integer id,

        LocalDateTime dataLogin,

        LocalDateTime dataLogout,

        String enderecoIp,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataAlteracao,

        UsuarioResumidoDTO usuario
) {
}
