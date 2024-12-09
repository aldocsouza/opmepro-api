package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoDetalhadaDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoRequestDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SolicitacaoDTOs.SolicitacaoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Solicitacao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SolicitacaoMapper {

    SolicitacaoMapper INSTANCE = Mappers.getMapper(SolicitacaoMapper.class);

    SolicitacaoResumidoDTO toSolicitacaoResumidoDTO(Solicitacao solicitacao);

    SolicitacaoDetalhadaDTO toSolicitacaoDetalhadaDTO(Solicitacao solicitacao);

    Solicitacao toEntity(SolicitacaoRequestDTO solicitacaoRequestDTO);


}
