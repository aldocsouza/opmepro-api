package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Credenciado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccreditedRepository extends JpaRepository<Credenciado, Integer> {

    Credenciado findByContractNumber(String contractNumber);
    Credenciado findByRegistry(String registry);
    Credenciado findByCnpj(String cnpj);
}
