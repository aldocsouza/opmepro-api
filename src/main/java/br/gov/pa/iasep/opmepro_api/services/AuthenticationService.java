package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.base.User;
import br.gov.pa.iasep.opmepro_api.config.security.TokenService;
import br.gov.pa.iasep.opmepro_api.exceptions.UserAlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.UserAgentDTOs.RequestUserAgentDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.AgentMapper;
import br.gov.pa.iasep.opmepro_api.repositories.AgentUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final AgentUserRepository agentUserRepository;

    private final AgentMapper agentMapper;

    private final TokenService tokenService;

    public AuthenticationService (AgentUserRepository agentUserRepository, AgentMapper agentMapper, TokenService tokenService){
        this.agentUserRepository = agentUserRepository;
        this.agentMapper = agentMapper;
        this.tokenService = tokenService;
    }

    public ApiResponse createAgentAccount(RequestUserAgentDTO userDto){
        if(agentUserRepository.findByUsername(userDto.username()) != null) throw new UserAlreadyExistsException("Já existe um usuário com o login informado");
        if(agentUserRepository.findByCpf(userDto.cpf()) != null) throw new UserAlreadyExistsException("Já existe um usuário com o CPF informado");
        if(agentUserRepository.findByEmail(userDto.email()) != null)  throw new UserAlreadyExistsException("Já existe um usuário com o e-mail informado");
        if(agentUserRepository.findByRegistry(userDto.registry()) != null) throw new UserAlreadyExistsException("Já existe um usuário com a matrícula informada");

        String encryptedPassword = new BCryptPasswordEncoder().encode(userDto.password());

        AgentUser agent = new AgentUser(
                userDto.name(),
                userDto.cpf(),
                userDto.username(),
                encryptedPassword,
                userDto.phone(),
                userDto.email(),
                userDto.status(),
                userDto.role(),
                userDto.lastSession(),
                userDto.registry(),
                userDto.affiliation()
        );

        agentUserRepository.save(agent);

        return new ApiResponse("Usuário cadastrado com sucesso!", true);
    }


//    public ApiResponse createAccountService(RequestUserDTO userDto){
//        if(userRepository.findByUsername(userDto.username()) != null) throw new UserAlreadyExistsException("Já existe um usuário com o login informado");
//        if(userRepository.findByCpf(userDto.cpf()) != null) throw new UserAlreadyExistsException("Já existe um usuário com o CPF informado");
//        if(userRepository.findByEmail(userDto.email()) != null)  throw new UserAlreadyExistsException("Já existe um usuário com o e-mail informado");
//        if(userRepository.findByRegistration(userDto.registration()) != null) throw new UserAlreadyExistsException("Já existe um usuário com a matrícula informada");
//
//        String encryptedPassword = new BCryptPasswordEncoder().encode(userDto.password());
//        User user = new User(
//                userDto.fullName(),
//                userDto.cpf(),
//                userDto.registration(),
//                userDto.email(),
//                userDto.phone(),
//                userDto.username(),
//                encryptedPassword,
//                userDto.situation(),
//                userDto.role()
//        );
//        userRepository.save(user);
//
//        return new ApiResponse("Usuário cadastrado com sucesso!", true);
//    }




//
//    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
//        var user = (User) userRepository.findByUsername(loginRequestDTO.username());
//
//        if (user != null && new BCryptPasswordEncoder().matches(loginRequestDTO.password(), user.getPassword())) {
//            var token = tokenService.generateToken(user);
//            return new LoginResponseDTO(token);
//        } else {
//            throw new UnauthorizedException("Usuário ou senha inválido!");
//        }
//    }

}
