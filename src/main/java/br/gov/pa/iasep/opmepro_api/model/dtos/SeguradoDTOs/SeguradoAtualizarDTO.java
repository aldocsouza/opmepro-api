package br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs;

public record SeguradoAtualizarDTO(
        Integer id,
        String nomeSegurado,
        String cpf,
        String termoAdesao,
        String sexo,
        Boolean status,
        String situacao,
        String municipio,
        String uf,
        Integer usuarioAlteracao
) {
}
