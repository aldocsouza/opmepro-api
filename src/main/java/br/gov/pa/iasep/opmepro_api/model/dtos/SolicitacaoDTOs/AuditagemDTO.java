package br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AuditagemDTO(
        UsuarioResumidoDTO usuario,

        SolicitacaoResumidoDTO solicitacao,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataAuditagem
) {
}
