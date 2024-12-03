package br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SolicitacaoRequestDTO(
        @NotNull @NotBlank
        String medico,

        String observacao,

        @NotNull
        Boolean status,

        @NotNull
        LocalDateTime dataSolicitacao,

        @NotNull @NotBlank
        String numProcesso,

        @NotNull @NotBlank
        String termoAdesao,

        @NotNull @NotBlank
        String grauParentesco,

        @NotNull
        CredenciadoResumidoDTO credenciado,

        @NotNull
        UsuarioResumidoDTO usuario,

        @NotNull
        SeguradoDTO segurado
) {
}
