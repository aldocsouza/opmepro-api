package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioValidacoesService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioValidacoesService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void checkForDuplicateUsername(String username) {
        if(usuarioRepository.findByUsername(username) != null)
            throw new AlreadyExistsException("Já existe um usuário com o login informado");
    }

    public void checkForDuplicateCpf(String cpf) {
        if(usuarioRepository.findByCpf(cpf) != null)
            throw new AlreadyExistsException("Já existe um usuário com o CPF informado");
    }

    public void checkForDuplicateEmail(String email) {
        if(usuarioRepository.findByEmail(email) != null)
            throw new AlreadyExistsException("Já existe um usuário com o e-mail informado");
    }
}
