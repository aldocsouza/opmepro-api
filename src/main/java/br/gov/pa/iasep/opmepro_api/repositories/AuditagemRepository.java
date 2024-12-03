package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Auditagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditagemRepository extends JpaRepository<Auditagem, Integer> {
}
