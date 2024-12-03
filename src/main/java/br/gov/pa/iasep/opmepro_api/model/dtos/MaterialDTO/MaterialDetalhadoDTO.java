package br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO;

import br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs.MaterialHistoricoDTO;

import java.util.List;

public record MaterialDetalhadoDTO(
        Integer id,

        String codigo,

        String descricao,

        Double valor,

        List<CodificacaoMaterialComSolicitacaoDTO> codificacoes,

        List<MaterialHistoricoDTO> materialHistoricoList
) {
}
