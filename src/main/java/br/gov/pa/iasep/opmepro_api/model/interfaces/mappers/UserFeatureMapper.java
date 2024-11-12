package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.FeaturesDTOs.UserPermissionsDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentFeature;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUserFeature;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserFeatureMapper {

    UserFeatureMapper INSTANCE = Mappers.getMapper(UserFeatureMapper.class);

    UserPermissionsDTO toUserPermissionsDTO(AgentFeature agentFeature);
    UserPermissionsDTO toUserPermissionsDTO(RegularUserFeature regularUserFeature);

}
