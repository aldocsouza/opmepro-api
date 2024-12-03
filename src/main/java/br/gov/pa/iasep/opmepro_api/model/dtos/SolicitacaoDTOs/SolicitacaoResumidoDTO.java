package br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SolicitacaoResumidoDTO(
        Integer id,

        String medico,

        String observacao,

        Boolean status,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataSolicitacao,

        String numProcesso,

        String termoAdesao,

        String grauParentesco,

        CredenciadoResumidoDTO credenciado,

        UsuarioResumidoDTO usuario,

        SeguradoDTO segurado
) {
}
