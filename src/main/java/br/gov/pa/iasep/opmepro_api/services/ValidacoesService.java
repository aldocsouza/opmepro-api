package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.AlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.repositories.CredenciadoRepository;
import br.gov.pa.iasep.opmepro_api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacoesService {

    private final UsuarioRepository usuarioRepository;
    private final CredenciadoRepository credenciadoRepository;

    @Autowired
    public ValidacoesService(UsuarioRepository usuarioRepository, CredenciadoRepository credenciadoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.credenciadoRepository = credenciadoRepository;
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

    public void checkForDuplicateCpfCredenciado(String cpf) {
        if(credenciadoRepository.findByCpf(cpf) != null)
            throw new AlreadyExistsException("Já existe um credenciado com o CPF informado");
    }

    public void checkForDuplicateCnpj(String cnpj) {
        if(credenciadoRepository.findByCnpj(cnpj) != null)
            throw new AlreadyExistsException("Já existe um credenciado com o CNPJ informado");
    }

    public void checkForDuplicateMatricula(String matricula) {
        if(credenciadoRepository.findByMatricula(matricula) != null)
            throw new AlreadyExistsException("Já existe um credenciado com a matricula informado");
    }

    public void checkForDuplicateNumContrato(String numContrato) {
        if(credenciadoRepository.findByNumContrato(numContrato) != null)
            throw new AlreadyExistsException("Já existe um credenciado com o contrato informado");
    }
}
