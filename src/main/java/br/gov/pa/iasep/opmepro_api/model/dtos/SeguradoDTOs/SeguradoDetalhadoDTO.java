package br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs;

import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.SeguradoHistorico;

import java.util.List;

public record SeguradoDetalhadoDTO (
        Integer id,
        String nomeSegurado,
        String cpf,
        String termoAdesao,
        String sexo,
        Boolean status,
        String situacao,
        String municipio,
        String uf,
        List<SolicitacaoResumidoDTO> solicitacaoList,
        List<SeguradoHistorico> seguradoHistoricoList
) {
}
