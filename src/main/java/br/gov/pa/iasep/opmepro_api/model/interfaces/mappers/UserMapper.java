package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.*;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.RegularUserCreateDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponseRegularUserNoListDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.ResponserRegularUserAndFeaturesDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /// USER_AGENT
    AgentUserCreateDTO toRequestAgentDTO(AgentUser agentUser);

    AgentUserUpdateDTO toRequestAgentUpdateDTO(AgentUserUpdateDTO agentUser);

    ResponseAgentDTO toAgentDTO(AgentUser agentUser);

    ResponseAgentAndFeaturesDTO toAgentAndFeaturesDTO(AgentUser agentUser);

    ResponseAgentNoListDTO toAgentNoListDTO(AgentUser agentUser);

    AgentUser toEntityAgent(AgentUserCreateDTO agentUserDto);

    AgentUser toEntityAgent(AgentUserUpdateDTO agentUserDto);

    /// REGULAR_USER
    RegularUser toEntityRegular(RegularUserCreateDTO regularUserDto);

    RegularUser toEntityRegularAccredited(RegularUserCreateDTO regularUserDto);

    RegularUserCreateDTO toRequestRegularDTO(RegularUser regularUser);

    ResponseRegularUserDTO toRegularUserDTO(RegularUser regularUser);

    ResponserRegularUserAndFeaturesDTO toRegularUserAndFeaturesDTO(RegularUser regularUser);

    ResponseRegularUserNoListDTO toRegularUserNoListDTO(RegularUser regularUser);

}
