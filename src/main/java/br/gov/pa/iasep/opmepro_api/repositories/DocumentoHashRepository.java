package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.DocumentoHash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoHashRepository extends JpaRepository<DocumentoHash, Integer> {
}
