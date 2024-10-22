package br.gov.pa.iasep.copme_api.model.services;

import br.gov.pa.iasep.copme_api.exceptions.UserNotFoundException;
import br.gov.pa.iasep.copme_api.infra.security.TokenService;
import br.gov.pa.iasep.copme_api.model.entities.DTOs.ResponseUserDTO;
import br.gov.pa.iasep.copme_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.copme_api.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService (UserRepository userRepository, UserMapper userMapper, TokenService tokenService){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<ResponseUserDTO> getAllUsers(){
        List<ResponseUserDTO> userList = this.userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());

        if(userList.isEmpty()){
            throw new UserNotFoundException("Nenhum usuário encontrado!");
        }

        return userList;
    }
}
