package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioFuncionalidadeRepository extends JpaRepository<UsuarioFuncionalidade, Integer> {
    Optional<UsuarioFuncionalidade> findByFuncionalidade(Funcionalidade funcionalidade);
    Optional<UsuarioFuncionalidade> findByUsuario(Usuario usuario);
}
