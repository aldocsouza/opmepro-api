package br.gov.pa.iasep.opmepro_api.model.dtos.DocumentoHashDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResumidoDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DocumentoHashCadastroDTO(

        @NotNull @NotBlank
        String hashDocumento,

        LocalDateTime dataCriacao,

        @NotNull @NotBlank
        String tipoDocumento,

        @NotNull @NotBlank
        String cnpj,

        @NotNull
        SolicitacaoResumidoDTO solicitacao
) {
}
