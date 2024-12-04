package br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CredenciadoCadastroDTO(

        @NotNull
        String matricula,

        String razaoSocial,

        @NotNull @NotBlank
        String nomeFantasia,

        String cnpj,

        String cpf,

        @NotNull @NotBlank
        String numContrato,

        Boolean status,

        String apelido,

        @NotNull
        CredenciadoTipoDTO tipoCredenciado
) {
}
