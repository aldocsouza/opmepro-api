package br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;

public record UsuarioFuncionalidadeResponseFuncDTO(
        UsuarioResumidoDTO usuario,
        Boolean leitura,
        Boolean escrita
) {
}
