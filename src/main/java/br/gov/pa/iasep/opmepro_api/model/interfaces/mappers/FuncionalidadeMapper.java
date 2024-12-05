package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.FuncionalidadeDetalhadoDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.FuncionalidadeDTOs.UsuarioFuncionalidadeResponseUsuarioDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.Funcionalidade;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioFuncionalidade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FuncionalidadeMapper {

    FuncionalidadeMapper INSTANCE = Mappers.getMapper(FuncionalidadeMapper.class);

    UsuarioFuncionalidadeResponseUsuarioDTO toUsuarioFuncionalidadeResponseUsuarioDTO(UsuarioFuncionalidade usuarioFuncionalidade);
    FuncionalidadeDetalhadoDTO toFuncionalidadeDetalhadoDTO(Funcionalidade funcionalidade);

}
