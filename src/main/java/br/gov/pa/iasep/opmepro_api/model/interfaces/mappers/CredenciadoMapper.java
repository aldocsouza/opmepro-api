package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.CredenciadoDTOs.*;
import br.gov.pa.iasep.opmepro_api.model.entities.Credenciado;
import br.gov.pa.iasep.opmepro_api.model.entities.CredenciadoTipo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CredenciadoMapper {

    CredenciadoMapper INSTANCE = Mappers.getMapper(CredenciadoMapper.class);

    CredenciadoResumidoDTO toCredenciadoResumidoDTO(Credenciado credenciado);

    CredenciadoDetalhadoDTO toCredenciadoDetalhadoDTO(Credenciado credenciado);

    CredenciadoComUsuariosDTO toCredenciadoFetchUsuariosDTO(Credenciado credenciado);

    Credenciado toEntity(CredenciadoResumidoDTO credenciadoResumidoDTO);

    Credenciado toEntity(CredenciadoCadastroDTO credenciadoCadastroDTO);

    CredenciadoTipo toEntity(CredenciadoTipoDTO credenciadoTipoDTO);

}
