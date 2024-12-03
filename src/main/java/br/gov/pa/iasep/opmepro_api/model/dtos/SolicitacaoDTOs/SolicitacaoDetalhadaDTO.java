package br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.DocumentoHashDTOs.DocumentoHashResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.MaterialDTO.CodificacaoMaterialComMaterialDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.CodificacaoProcedimento;
import br.gov.pa.iasep.opmepro_api.model.entities.SolicitacaoHistorico;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record SolicitacaoDetalhadaDTO(

        Integer id,

        String medico,

        String observacao,

        Boolean status,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataSolicitacao,

        String numProcesso,

        String termoAdesao,

        String grauParentesco,

        CredenciadoResumidoDTO credenciado,

        UsuarioResumidoDTO usuario,

        SeguradoDTO segurado,

        List<AuditagemDTO> auditagemList,

        List<DocumentoHashResumidoDTO> documentoHashList,

        List<CodificacaoMaterialComMaterialDTO> codificacaoMaterialList,

        List<CodificacaoProcedimento> codificacaoProcedimentoList,

        List<SolicitacaoHistorico> solicitacaoHistoricoList
) {
}
