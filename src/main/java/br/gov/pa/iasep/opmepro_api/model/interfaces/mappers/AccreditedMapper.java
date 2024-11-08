package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.AccreditedAndUsersDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.AccreditedCreateDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.ResponseAccreditedDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.AccreditedDTOs.UserAccreditedCreateDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Accredited;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccreditedMapper {

    AccreditedMapper INSTANCE = Mappers.getMapper(AccreditedMapper.class);

    AccreditedCreateDTO toRequestDTO(Accredited accredited);

    ResponseAccreditedDTO toResponseDTO(Accredited accredited);

    AccreditedAndUsersDTO toResponseUsersDTO(Accredited accredited);

    Accredited toEntity(AccreditedCreateDTO accreditedDTO);

    Accredited toEntity(UserAccreditedCreateDTO accreditedDTO);

}
