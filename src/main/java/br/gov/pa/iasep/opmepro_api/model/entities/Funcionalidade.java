package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcionalidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "funcionalidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioFuncionalidade> usuarioFuncionalidades = new ArrayList<>();
}
