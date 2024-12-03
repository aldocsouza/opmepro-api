package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.CodificacaoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodificacaoMaterialRepository extends JpaRepository<CodificacaoMaterial, Integer> {
}
