package br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO;

public record MaterialCadastroDTO (
        String codigo,
        String descricao,
        Double valor
) {
}
