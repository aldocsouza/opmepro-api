package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import br.gov.pa.iasep.opmepro_api.model.entities.SessionHistoryRegularUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionHistoryRegularRepository extends JpaRepository<SessionHistoryRegularUser, Integer> {
    SessionHistoryRegularUser findTopByRegularUserOrderByLoginDateDesc (RegularUser regularUser);
}
