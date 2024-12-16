package br.gov.pa.iasep.opmepro_api.repositories;

import br.gov.pa.iasep.opmepro_api.model.entities.Segurado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeguradoRepository extends JpaRepository<Segurado, Integer> {

    //Optional<Segurado> findByTermoAdesaoOrNomeSeguradoOrCpf(String consulta);
    Optional<Segurado> findByTermoAdesaoOrNomeSeguradoOrCpf(String termoAdesao, String nomeSegurado, String cpf);

    Segurado findByTermoAdesao(String termoAdesao);
    Segurado findByCpf(String cpf);

}
