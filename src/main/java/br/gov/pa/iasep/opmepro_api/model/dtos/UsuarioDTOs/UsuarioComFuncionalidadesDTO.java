package br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioFuncionalidadeResponseUsuarioDTO;

import java.util.List;

public record UsuarioComFuncionalidadesDTO(
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

        List<UsuarioFuncionalidadeResponseUsuarioDTO> usuarioFuncionalidadeList
) {
}
