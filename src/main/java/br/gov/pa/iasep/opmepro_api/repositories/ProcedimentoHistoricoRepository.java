package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.ProcedimentoHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimentoHistoricoRepository extends JpaRepository<ProcedimentoHistorico, Integer> {
}
