package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioHistoricoRepository extends JpaRepository<UsuarioHistorico, Integer> {
}
