package br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioFuncionalidadeDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs.UsuarioHistoricoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs.UsuarioHistoricoSessaoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.AuditagemDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResumidoDTO;

import java.util.List;

public record UsuarioDetalhadoDTO(

        Integer id,

        String nome,

        String cpf,

        String username,

        String password,

        String telefone,

        String email,

        Boolean situacao,

        CredenciadoResumidoDTO credenciado,

        UsuarioPerfilResumidoDTO perfil,

        UsuarioSituacaoResumidoDTO usuarioSituacao,

        List<UsuarioFuncionalidadeDTO> usuarioFuncionalidadeList,

        List<UsuarioHistoricoSessaoDTO> usuarioHistoricoSessaoList,

        List<UsuarioHistoricoDTO> usuarioHistoricoList,

        List<SolicitacaoResumidoDTO> solicitacaoList,

        List<AuditagemDTO> auditagemList
) {
}
