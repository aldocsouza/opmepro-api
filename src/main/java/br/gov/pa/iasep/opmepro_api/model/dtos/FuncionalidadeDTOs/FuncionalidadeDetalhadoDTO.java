package br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs;

import java.util.List;

public record FuncionalidadeDetalhadoDTO (
        Integer id,
        String descricao,
        List<UsuarioFuncionalidadeResponseFuncDTO> usuarioFuncionalidades
) {
}
