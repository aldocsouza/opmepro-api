package br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs.CredenciadoHistoricoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.CredenciadoHistorico;
import br.gov.pa.iasep.opmepro_api.model.entities.Solicitacao;

import java.util.List;

public record CredenciadoDetalhadoDTO(
        Integer id,

        String matricula,

        String razaoSocial,

        String nomeFantasia,

        String cnpj,

        String cpf,

        String numContrato,

        Boolean status,

        String apelido,

        CredenciadoTipoDTO tipoCredenciado,

        List<UsuarioResumidoDTO> usuarios,

        List<CredenciadoHistoricoResumidoDTO> credenciadoHistoricoList,

        List<SolicitacaoResumidoDTO> solicitacaoList
) {
}
