package br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCadastroDTO(

        @NotNull @NotBlank
        String nome,

        @NotNull @NotBlank
        String cpf,

        @NotNull @NotBlank
        String username,

        @NotNull @NotBlank
        String password,

        @NotNull @NotBlank
        String telefone,

        @NotNull @NotBlank
        String email,

        @NotNull
        Boolean situacao,

        CredenciadoResumidoDTO credenciado,

        @NotNull
        UsuarioPerfilResumidoDTO perfil,

        @NotNull
        UsuarioSituacaoResumidoDTO situacaoUsuario
) {
}
