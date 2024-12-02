package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_funcionalidade")
@Getter
@Setter
@IdClass(UsuarioFuncionalidadeId.class)
public class UsuarioFuncionalidade {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionalidade", nullable = false)
    private Funcionalidade funcionalidade;

    @Column(name = "leitura", nullable = false)
    private Boolean reading;

    @Column(name = "escrita", nullable = false)
    private Boolean writing;
}
