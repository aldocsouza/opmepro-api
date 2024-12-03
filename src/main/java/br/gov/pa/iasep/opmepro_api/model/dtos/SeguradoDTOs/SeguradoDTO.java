package br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs;

public record SeguradoDTO(
        Integer id,
        String nomeSegurado,
        String cpf,
        String sexo,
        Boolean status,
        String situacao,
        String municipio,
        String uf
) {
}
