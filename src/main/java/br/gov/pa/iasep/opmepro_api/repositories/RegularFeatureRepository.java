package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.RegularUserFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegularFeatureRepository extends JpaRepository<RegularUserFeature, Integer> {
}
