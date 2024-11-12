package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.SessionHistoryAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionHistoryAgentRepository extends JpaRepository <SessionHistoryAgent, Integer>{
    SessionHistoryAgent findTopByAgentOrderByLoginDateDesc(AgentUser agent);
}
