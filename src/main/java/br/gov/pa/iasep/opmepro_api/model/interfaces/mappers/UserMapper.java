package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.entities.DTOs.RequestUserDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.DTOs.ResponseUserDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(RequestUserDTO requestUserDTO);

    ResponseUserDTO toResponseDTO(User user);

}
