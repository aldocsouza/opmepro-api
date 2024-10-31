package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Accredited;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccreditedRepository extends JpaRepository<Accredited, Integer> {

    Accredited findByContractNumber(String contractNumber);
    Accredited findByRegistry(String registry);
    Accredited findByCnpj(String cnpj);
}
