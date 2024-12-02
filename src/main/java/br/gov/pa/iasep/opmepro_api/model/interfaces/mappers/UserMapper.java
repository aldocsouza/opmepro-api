package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.*;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.RegularUserCreateDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserNoListDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponserRegularUserAndFeaturesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /// REGULAR_USER
    RegularUser toEntityRegular(RegularUserCreateDTO regularUserDto);

    RegularUser toEntityRegularAccredited(RegularUserCreateDTO regularUserDto);

    RegularUserCreateDTO toRequestRegularDTO(RegularUser regularUser);

    ResponseRegularUserDTO toRegularUserDTO(RegularUser regularUser);

    ResponserRegularUserAndFeaturesDTO toRegularUserAndFeaturesDTO(RegularUser regularUser);

    ResponseRegularUserNoListDTO toRegularUserNoListDTO(RegularUser regularUser);

}
