package br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs;

public record UsuarioPermissoesDTO(
        FuncionalidadeResumidoDTO funcionalidade,
        Boolean leitura,
        Boolean escrita
) {
}
