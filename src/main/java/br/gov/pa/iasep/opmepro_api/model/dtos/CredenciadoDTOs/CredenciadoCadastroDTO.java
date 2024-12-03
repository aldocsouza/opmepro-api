package br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs;

public record CredenciadoCadastroDTO(

        String matricula,

        String razaoSocial,

        String nomeFantasia,

        String cnpj,

        String numContrato,

        String apelido,

        CredenciadoTipoDTO tipoCredenciado
) {
}
