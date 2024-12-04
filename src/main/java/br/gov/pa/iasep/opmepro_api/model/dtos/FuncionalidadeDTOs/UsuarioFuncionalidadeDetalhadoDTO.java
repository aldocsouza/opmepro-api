package br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;

public record UsuarioFuncionalidadeDetalhadoDTO(
        UsuarioResumidoDTO usuario,
        FuncionalidadeResumidoDTO funcionalidade,
        Boolean leitura,
        Boolean escrita
) {
}
