package br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO;

import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResumidoDTO;

public record CodificacaoMaterialComSolicitacaoDTO(

        SolicitacaoResumidoDTO solicitacao,

        Integer qtdSolicitado,

        Integer qtdAutorizado
) {
}
