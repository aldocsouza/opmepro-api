package br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;

public record UsuarioResumidoDTO(
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

        UsuarioSituacaoResumidoDTO situacaoUsuario
) {
}
