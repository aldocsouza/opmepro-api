package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegularFeatureRepository extends JpaRepository<RegularUserFeature, Integer> {
    Optional<RegularUserFeature> findByFeature(Feature feature);

    List<RegularUserFeature> findByRegularUser(RegularUser regularUser);
}
