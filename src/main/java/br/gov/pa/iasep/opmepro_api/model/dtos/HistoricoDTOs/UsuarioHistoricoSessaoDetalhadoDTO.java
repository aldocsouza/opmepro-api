package br.gov.pa.iasep.opmepro_api.model.dtos.HistoricoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.UsuarioResumidoDTO;

import java.time.LocalDateTime;

public record UsuarioHistoricoSessaoDetalhadoDTO(
        Integer id,

        LocalDateTime dataLogin,

        LocalDateTime dataLogout,

        String enderecoIp,

        UsuarioResumidoDTO usuario
) {
}
