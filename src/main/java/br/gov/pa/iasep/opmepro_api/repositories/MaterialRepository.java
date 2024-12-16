package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Material;
import br.gov.pa.iasep.opmepro_api.model.entities.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    Material findByCodigo(String codigo);
}
