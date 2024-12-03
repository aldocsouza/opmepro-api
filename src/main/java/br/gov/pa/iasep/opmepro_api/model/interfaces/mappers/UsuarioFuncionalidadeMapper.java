package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioPermissoesDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioFuncionalidade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioFuncionalidadeMapper {

    UsuarioFuncionalidadeMapper INSTANCE = Mappers.getMapper(UsuarioFuncionalidadeMapper.class);

    UsuarioPermissoesDTO toUsuarioPermissoesDTO(UsuarioFuncionalidade usuarioFuncionalidade);

}
