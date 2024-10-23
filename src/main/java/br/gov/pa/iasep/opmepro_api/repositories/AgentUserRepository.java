package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AgentUserRepository extends JpaRepository<AgentUser, Integer> {

    UserDetails findByCpf(String cpf);

    UserDetails findByRegistry(String registry);

    UserDetails findByUsername(String username);

    UserDetails findByEmail(String email);

}
