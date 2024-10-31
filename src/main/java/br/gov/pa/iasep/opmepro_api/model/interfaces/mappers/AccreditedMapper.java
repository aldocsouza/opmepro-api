package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.RequestAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.ResponseAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Accredited;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccreditedMapper {

    AccreditedMapper INSTANCE = Mappers.getMapper(AccreditedMapper.class);

    RequestAccreditedDTO toRequestDTO(Accredited accredited);

    ResponseAccreditedDTO toResponseDTO(Accredited accredited);

    Accredited toEntity(RequestAccreditedDTO accreditedDTO);

}
