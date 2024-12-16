package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer> {
    Optional<Procedimento> findByCodigo(String codigo);
}
