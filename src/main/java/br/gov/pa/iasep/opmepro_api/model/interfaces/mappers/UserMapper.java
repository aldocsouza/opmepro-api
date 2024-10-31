package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.RequestAgentDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.ResponseAgentDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.RequestRegularUserDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    RequestAgentDTO toRequestAgentDTO(AgentUser agentUser);

    RequestRegularUserDTO toRequestRegularDTO(RegularUser regularUser);

    ResponseAgentDTO toResponseAgentDTO(AgentUser agentUser);

    ResponseRegularUserDTO toResponseRegularDTO(RegularUser regularUser);

    AgentUser toEntityAgent(RequestAgentDTO agentUserDto);

    RegularUser toEntityRegular(RequestAgentDTO regularUserDto);

    RegularUser toEntityRegularAccredited(RequestRegularUserDTO regularUserDto);

}
