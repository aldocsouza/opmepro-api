package br.gov.pa.iasep.opmepro_api.model.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);
    UserDetails findByCpf(String cpf);
    UserDetails findByRegistration(String registration);
    UserDetails findByEmail(String email);

}
