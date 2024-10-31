package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.model.dtos.UserRegularDTOs.ResponseRegularUserDTO;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.opmepro_api.repositories.RegularUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegularUserService {

    private final RegularUserRepository regularUserRepository;
    private final UserMapper userMapper;

    public RegularUserService(RegularUserRepository regularUserRepository, UserMapper userMapper) {
        this.regularUserRepository = regularUserRepository;
        this.userMapper = userMapper;
    }

    public List<ResponseRegularUserDTO> getAllRegularUsers(){
        return regularUserRepository.findAll().stream().map(userMapper::toResponseRegularDTO).toList();
    }

}
