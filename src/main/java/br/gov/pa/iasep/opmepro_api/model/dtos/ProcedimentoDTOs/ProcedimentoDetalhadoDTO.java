package br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs.ProcedimentoHistoricoDTO;

import java.util.List;

public record ProcedimentoDetalhadoDTO(
        Integer id,

        String codigo,

        String descricao,

        Double valor,

        List<CodificacaoProcedimentoComSolicitacaoDTO> codificacoes,

        List<ProcedimentoHistoricoDTO> materialHistoricoList
) {
}
