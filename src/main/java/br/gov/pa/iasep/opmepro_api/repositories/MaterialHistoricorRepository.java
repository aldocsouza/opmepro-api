package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.MaterialHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialHistoricorRepository extends JpaRepository<MaterialHistorico, Integer> {
}
