package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Funcionalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionalidadeRepository extends JpaRepository<Funcionalidade, Integer> {
}