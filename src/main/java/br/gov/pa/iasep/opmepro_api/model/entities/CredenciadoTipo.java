package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_credenciado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CredenciadoTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "tipoCredenciado")
    private List<Credenciado> credenciados = new ArrayList<>();

}
