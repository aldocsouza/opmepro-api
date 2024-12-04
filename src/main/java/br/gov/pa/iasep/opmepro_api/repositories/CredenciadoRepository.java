package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Credenciado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface CredenciadoRepository extends JpaRepository<Credenciado, Integer> {

    Credenciado findByNumContrato(String numContrato);
    Credenciado findByMatricula(String matricula);
    Credenciado findByCnpj(String cnpj);
    Credenciado findByCpf(String cpf);
}
