package br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;

import java.util.List;

public record CredenciadoFetchUsuariosDTO (

        Integer id,

        String matricula,

        String razaoSocial,

        String nomeFantasia,

        String cnpj,

        String numContrato,

        String apelido,

        CredenciadoTipoDTO tipoCredenciado,

        List<UsuarioResumidoDTO> usuarios
) {
}
