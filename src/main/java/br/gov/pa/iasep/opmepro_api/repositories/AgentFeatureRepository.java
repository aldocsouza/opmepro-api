package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.AgentFeature;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgentFeatureRepository extends JpaRepository<AgentFeature, Integer> {
    Optional<AgentFeature> findByFeature(Feature feature);

    List<AgentFeature> findByAgent(AgentUser agent);
}
