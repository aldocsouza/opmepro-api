package br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs;

public record UsuarioFuncionalidadeResponseUsuarioDTO(
        FuncionalidadeResumidoDTO funcionalidade,
        Boolean leitura,
        Boolean escrita
) {
}
