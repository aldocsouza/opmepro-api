package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoCadastroDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoFetchUsuariosDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.CredenciadoResumidoDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Credenciado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CredenciadoMapper {

    CredenciadoMapper INSTANCE = Mappers.getMapper(CredenciadoMapper.class);

    CredenciadoResumidoDTO toResponseDTO(Credenciado credenciado);

    CredenciadoFetchUsuariosDTO toResponseUsersDTO(Credenciado credenciado);

    Credenciado toEntity(CredenciadoResumidoDTO credenciadoResumidoDTO);

    Credenciado toEntity(CredenciadoCadastroDTO credenciadoCadastroDTO);

}
