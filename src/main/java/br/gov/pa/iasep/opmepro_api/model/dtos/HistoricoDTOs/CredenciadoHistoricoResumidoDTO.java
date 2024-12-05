package br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CredenciadoHistoricoResumidoDTO (
        Integer id,

        String matricula,

        String razaoSocial,

        String nomeFantasia,

        String cnpj,

        String cpf,

        String numContrato,

        Boolean status,

        String apelido,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataAlteracao,

        Integer usuarioAlteracao,

        Integer tipoCredenciado
) {
}
