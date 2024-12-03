package br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs;

public record CodificacaoProcedimentoComProcedimentoDTO(

        ProcedimentoResumidoDTO procedimento,

        Integer qtdSolicitado,

        Integer qtdAutorizado
) {
}
