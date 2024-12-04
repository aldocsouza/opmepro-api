package br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioFuncionalidadeResponseUsuarioDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs.UsuarioHistoricoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs.UsuarioHistoricoSessaoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.AuditagemResponseUsuarioDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResponseUsuarioDTO;

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

        UsuarioSituacaoResumidoDTO situacaoUsuario,

        List<UsuarioFuncionalidadeResponseUsuarioDTO> usuarioFuncionalidadeList,

        List<UsuarioHistoricoSessaoResumidoDTO> usuarioHistoricoSessaoList,

        List<UsuarioHistoricoResumidoDTO> usuarioHistoricoList,

        List<SolicitacaoResponseUsuarioDTO> solicitacaoList,

        List<AuditagemResponseUsuarioDTO> auditagemList
) {
}
