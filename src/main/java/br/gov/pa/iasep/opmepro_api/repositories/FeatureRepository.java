package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Integer> {
}
