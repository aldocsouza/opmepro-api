package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.SeguradoDTOs.SeguradoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Segurado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeguradoMapper {

    SeguradoMapper INSTANCE = Mappers.getMapper(SeguradoMapper.class);

    Segurado toEntity(SeguradoResumidoDTO seguradoResumidoDTO);
    Segurado toEntity(SeguradoDetalhadoDTO seguradoDetalhadoDTO);
    Segurado toEntity(SeguradoCadastroDTO seguradoCadastroDTO);

    SeguradoResumidoDTO toSeguradoResumidoDTO(Segurado segurado);
    SeguradoDetalhadoDTO toSeguradoDetalhadoDTO(Segurado segurado);

}
