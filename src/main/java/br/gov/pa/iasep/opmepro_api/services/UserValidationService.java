package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

    private final AgentUserRepository agentUserRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserValidationService(AgentUserRepository agentUserRepository, UserRepository userRepository) {
        this.agentUserRepository = agentUserRepository;
        this.userRepository = userRepository;
    }

    public void checkForDuplicateUsername(String username) {
        if(agentUserRepository.findByUsername(username) != null || userRepository.findByUsername(username) != null)
            throw new AlreadyExistsException("Já existe um usuário com o login informado");
    }

    public void checkForDuplicateCpf(String cpf) {
        if(agentUserRepository.findByCpf(cpf) != null || userRepository.findByCpf(cpf) != null)
            throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
    }

    public void checkForDuplicateEmail(String email) {
        if(agentUserRepository.findByEmail(email) != null || userRepository.findByEmail(email) != null)
            throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");
    }

    public void checkForDuplicateRegistry(String registry) {
        if(agentUserRepository.findByRegistry(registry) != null)
            throw new AlreadyExistsException("Já existe um usuário com a matrícula informada");
    }

}
