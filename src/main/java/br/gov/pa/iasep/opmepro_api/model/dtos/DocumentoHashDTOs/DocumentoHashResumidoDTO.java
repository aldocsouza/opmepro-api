package br.gov.pa.iasep.opmepro_api.model.dtos.DocumentoHashDTOs;

import java.time.LocalDateTime;

public record DocumentoHashResumidoDTO(

        Integer id,

        String hashDocumento,

        LocalDateTime dataCriacao,

        String tipoDocumento,

        String cnpj
) {
}
