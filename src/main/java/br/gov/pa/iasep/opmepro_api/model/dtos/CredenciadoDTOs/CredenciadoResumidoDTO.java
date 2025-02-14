package br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs;

public record CredenciadoResumidoDTO(

        Integer id,

        String matricula,

        String razaoSocial,

        String nomeFantasia,

        String cnpj,

        String cpf,

        String numContrato,

        Boolean status,

        String apelido,

        CredenciadoTipoDTO tipoCredenciado
) {}
