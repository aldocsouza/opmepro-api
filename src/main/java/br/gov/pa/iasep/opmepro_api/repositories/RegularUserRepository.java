package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RegularUserRepository extends JpaRepository<RegularUser, Integer> {

    UserDetails findByCpf(String cpf);

    UserDetails findByUsername(String username);

    UserDetails findByEmail(String email);
}
