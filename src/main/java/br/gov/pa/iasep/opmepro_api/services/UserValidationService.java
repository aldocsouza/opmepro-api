package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.repositories.AgentUserRepository;
import br.gov.pa.iasep.opmepro_api.repositories.RegularUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

    private final AgentUserRepository agentUserRepository;
    private final RegularUserRepository regularUserRepository;

    @Autowired
    public UserValidationService(AgentUserRepository agentUserRepository, RegularUserRepository regularUserRepository) {
        this.agentUserRepository = agentUserRepository;
        this.regularUserRepository = regularUserRepository;
    }

    public void checkForDuplicateUsername(String username) {
        if(agentUserRepository.findByUsername(username) != null || regularUserRepository.findByUsername(username) != null)
            throw new AlreadyExistsException("Já existe um usuário com o login informado");
    }

    public void checkForDuplicateCpf(String cpf) {
        if(agentUserRepository.findByCpf(cpf) != null || regularUserRepository.findByCpf(cpf) != null)
            throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
    }

    public void checkForDuplicateEmail(String email) {
        if(agentUserRepository.findByEmail(email) != null || regularUserRepository.findByEmail(email) != null)
            throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");
    }

    public void checkForDuplicateRegistry(String registry) {
        if(agentUserRepository.findByRegistry(registry) != null)
            throw new AlreadyExistsException("Já existe um usuário com a matrícula informada");
    }

}
