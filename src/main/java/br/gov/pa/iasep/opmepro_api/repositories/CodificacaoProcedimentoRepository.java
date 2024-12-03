package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.CodificacaoProcedimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodificacaoProcedimentoRepository extends JpaRepository<CodificacaoProcedimento, Integer> {
}
