package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Segurado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguradoRepository extends JpaRepository<Segurado, Integer> {
}
