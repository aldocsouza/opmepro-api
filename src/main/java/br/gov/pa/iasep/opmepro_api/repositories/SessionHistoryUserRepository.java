package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioHistoricoSessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionHistoryUserRepository extends JpaRepository<UsuarioHistoricoSessao, Integer> {
    UsuarioHistoricoSessao findTopByRegularUserOrderByLoginDateDesc (RegularUser regularUser);
}
