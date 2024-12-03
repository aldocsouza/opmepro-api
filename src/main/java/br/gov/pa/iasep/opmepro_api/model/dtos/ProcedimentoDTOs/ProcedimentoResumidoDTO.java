package br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs;

public record ProcedimentoResumidoDTO(
        Integer id,

        String codigo,

        String descricao,

        Double valor
) {
}
