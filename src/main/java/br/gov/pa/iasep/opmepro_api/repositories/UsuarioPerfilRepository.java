package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Integer> {
}
