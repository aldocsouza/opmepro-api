package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
}
