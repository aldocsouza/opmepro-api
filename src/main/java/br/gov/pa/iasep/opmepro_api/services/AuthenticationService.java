package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.config.security.TokenService;
import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.UnauthorizedException;
import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginRequestDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.LoginDTOs.LoginResponseDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserAgentDTOs.AgentUserCreateDTO;
import br.gov.pa.iasep.opmepro_api.model.dtos.UsersDTOs.UserRegularDTOs.RegularUserCreateDTO;
import br.gov.pa.iasep.opmepro_api.model.interfaces.mappers.UserMapper;
import br.gov.pa.iasep.opmepro_api.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final AgentUserRepository agentUserRepository;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final TokenService tokenService;

    private final SessionHistoryService sessionHistoryService;

    public AuthenticationService (AgentUserRepository agentUserRepository, UserRepository userRepository, UserMapper userMapper, TokenService tokenService, SessionHistoryService sessionHistoryService){
        this.agentUserRepository = agentUserRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.tokenService = tokenService;
        this.sessionHistoryService = sessionHistoryService;
    }

    public ApiResponse createAgentAccount(AgentUserCreateDTO userDto){
        if(agentUserRepository.findByUsername(userDto.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
        if(agentUserRepository.findByCpf(userDto.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
        if(agentUserRepository.findByEmail(userDto.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");
        if(agentUserRepository.findByRegistry(userDto.registry()) != null) throw new AlreadyExistsException("Já existe um usuário com a matrícula informada");

        if(userRepository.findByUsername(userDto.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
        if(userRepository.findByCpf(userDto.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
        if(userRepository.findByEmail(userDto.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");

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

    public ApiResponse createRegularUserAccount(RegularUserCreateDTO userDto){
        if(agentUserRepository.findByUsername(userDto.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
        if(agentUserRepository.findByCpf(userDto.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
        if(agentUserRepository.findByEmail(userDto.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");

        if(userRepository.findByUsername(userDto.username()) != null) throw new AlreadyExistsException("Já existe um usuário com o login informado");
        if(userRepository.findByCpf(userDto.cpf()) != null) throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
        if(userRepository.findByEmail(userDto.email()) != null)  throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");

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

        userRepository.save(regularUser);

        return new ApiResponse("Usuário cadastrado com sucesso!", true);
    }


    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO, HttpServletRequest request){
        User user = (AgentUser) agentUserRepository.findByUsername(loginRequestDTO.username());

        if(user == null){
            user = (RegularUser) userRepository.findByUsername(loginRequestDTO.username());
        }

        if (user != null && new BCryptPasswordEncoder().matches(loginRequestDTO.password(), user.getPassword())) {

            if(!user.getStatus()){
                throw new UnauthorizedException("Usuário não autorizado, a conta deste usuário está desativada!");
            }

            var token = tokenService.generateToken(user);

            if (user instanceof AgentUser agentUser){
                this.sessionHistoryService.startSessionHistoryAgent(agentUser, request.getRemoteAddr());
            } else {
                RegularUser regularUser = (RegularUser) user;
                this.sessionHistoryService.startSessionHistoryRegular(regularUser, request.getRemoteAddr());
            }

            return new LoginResponseDTO(token);
        } else {
            throw new UnauthorizedException("Usuário ou senha inválido!");
        }
    }

}
