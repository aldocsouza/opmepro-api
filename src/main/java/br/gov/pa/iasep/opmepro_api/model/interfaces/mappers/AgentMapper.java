package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.UserAgentDTOs.RequestUserAgentDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AgentMapper {

    AgentMapper INSTANCE = Mappers.getMapper(AgentMapper.class);

    RequestUserAgentDTO toDTO(AgentUser agentUser);

    AgentUser toEntity(RequestUserAgentDTO agentUserDto);

}
