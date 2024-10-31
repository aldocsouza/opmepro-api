package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.base.User;
import br.gov.pa.iasep.opmepro_api.config.security.TokenService;
import br.gov.pa.iasep.opmepro_api.exceptions.UnauthorizedException;
import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginRequestDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginResponseDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UserAgentDTOs.RequestAgentDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UserRegularDTOs.RequestRegularUserDTO;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.opmepro_api.repositories.AgentUserRepository;
import br.gov.pa.iasep.opmepro_api.repositories.RegularUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final AgentUserRepository agentUserRepository;

    private final RegularUserRepository regularUserRepository;

    private final UserMapper userMapper;

    private final TokenService tokenService;

    public AuthenticationService (AgentUserRepository agentUserRepository, RegularUserRepository regularUserRepository, UserMapper userMapper, TokenService tokenService){
        this.agentUserRepository = agentUserRepository;
        this.regularUserRepository = regularUserRepository;
        this.userMapper = userMapper;
        this.tokenService = tokenService;
    }

    public ApiResponse createAgentAccount(RequestAgentDTO userDto){
        if(agentUserRepository.findByUsername(userDto.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
        if(agentUserRepository.findByCpf(userDto.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
        if(agentUserRepository.findByEmail(userDto.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");
        if(agentUserRepository.findByRegistry(userDto.registry()) != null) throw new AlreadyExistsException("Já existe um usuário com a matrícula informada");

        if(regularUserRepository.findByUsername(userDto.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
        if(regularUserRepository.findByCpf(userDto.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
        if(regularUserRepository.findByEmail(userDto.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");

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
                userDto.registry(),
                userDto.affiliation()
        );

        agentUserRepository.save(agent);

        return new ApiResponse("Usuário cadastrado com sucesso!", true);
    }

    public ApiResponse createRegularUserAccount(RequestRegularUserDTO userDto){
        if(agentUserRepository.findByUsername(userDto.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
        if(agentUserRepository.findByCpf(userDto.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
        if(agentUserRepository.findByEmail(userDto.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");

        if(regularUserRepository.findByUsername(userDto.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
        if(regularUserRepository.findByCpf(userDto.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
        if(regularUserRepository.findByEmail(userDto.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");

        String encryptedPassword = new BCryptPasswordEncoder().encode(userDto.password());

        RegularUser regularUser = new RegularUser(
                userDto.name(),
                userDto.cpf(),
                userDto.username(),
                encryptedPassword,
                userDto.phone(),
                userDto.email(),
                userDto.status(),
                userDto.role(),
                userMapper.toEntityRegularAccredited(userDto).getAccredited()
        );

        regularUserRepository.save(regularUser);

        return new ApiResponse("Usuário cadastrado com sucesso!", true);
    }


    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
        User user = (AgentUser) agentUserRepository.findByUsername(loginRequestDTO.username());

        if(user == null){
            user = (RegularUser) regularUserRepository.findByUsername(loginRequestDTO.username());
        }

        if (user != null && new BCryptPasswordEncoder().matches(loginRequestDTO.password(), user.getPassword())) {
            var token = tokenService.generateToken(user);
            return new LoginResponseDTO(token);
        } else {
            throw new UnauthorizedException("Usuário ou senha inválido!");
        }
    }

}
