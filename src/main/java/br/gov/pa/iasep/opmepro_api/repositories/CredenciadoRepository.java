package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Credenciado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredenciadoRepository extends JpaRepository<Credenciado, Integer> {

    Credenciado findByNumContrato(String numContrato);
    Credenciado findByMatricula(String matricula);
    Credenciado findByCnpj(String cnpj);
}
