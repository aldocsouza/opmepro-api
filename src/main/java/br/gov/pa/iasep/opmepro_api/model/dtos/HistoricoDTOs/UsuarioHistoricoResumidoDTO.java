package br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UsuarioHistoricoResumidoDTO(
        Integer id,

        String nome,

        String cpf,

        String username,

        String password,

        String telefone,

        String email,

        Boolean situacao,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataAlteracao,

        Integer usuarioAlteracao,

        Integer perfil,

        Integer credenciado
) {
}
