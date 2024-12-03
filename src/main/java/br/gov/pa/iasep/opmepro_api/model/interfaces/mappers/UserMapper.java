package br.gov.pa.iasep.opmepro_api.model.interfaces.mappers;

import br.gov.pa.iasep.opmepro_api.model.dtos.UsuarioDTOs.*;
import br.gov.pa.iasep.opmepro_api.model.entities.Usuario;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioPerfil;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioSituacao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    ///Usuario
    Usuario toEntity(UsuarioCadastroDTO usuarioCadastroDTO);

    UsuarioCadastroDTO toRequestRegularDTO(Usuario usuario);

    UsuarioResumidoDTO toUsuarioDTO(Usuario usuario);

    UsuarioComFuncionalidadesDTO toUsuarioAndFuncionalidadesDTO(Usuario usuario);

    UsuarioDetalhadoDTO toUsuarioListasDTO(Usuario usuario);

    ///UsuarioSituacao
    UsuarioSituacao toEntity(UsuarioSituacaoResumidoDTO usuarioSituacaoResumidoDTO);

    //UsuarioPerfil
    UsuarioPerfil toEntity(UsuarioPerfilResumidoDTO usuarioPerfilResumidoDTO);

}
