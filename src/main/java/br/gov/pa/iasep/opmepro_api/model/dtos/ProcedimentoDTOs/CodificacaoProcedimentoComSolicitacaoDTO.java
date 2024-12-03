package br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResumidoDTO;

public record CodificacaoProcedimentoComSolicitacaoDTO(

        SolicitacaoResumidoDTO solicitacao,

        Integer qtdSolicitado,

        Integer qtdAutorizado
) {
}
