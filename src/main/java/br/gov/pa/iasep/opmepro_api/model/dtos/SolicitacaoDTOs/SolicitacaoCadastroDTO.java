package br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.CodificacaoMaterialComMaterialDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.ProcedimentoDTOs.CodificacaoProcedimentoComProcedimentoDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SolicitacaoCadastroDTO(

        @NotNull
        SolicitacaoRequestDTO solicitacao,

        List<CodificacaoMaterialComMaterialDTO> codificacaoMaterialList,

        List<CodificacaoProcedimentoComProcedimentoDTO> codificacaoProcedimentoList

) {
}
