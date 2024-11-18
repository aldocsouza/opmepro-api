package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
