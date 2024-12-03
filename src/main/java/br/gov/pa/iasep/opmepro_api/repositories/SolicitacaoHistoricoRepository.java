package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.SolicitacaoHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoHistoricoRepository extends JpaRepository<SolicitacaoHistorico, Integer> {
}
