package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_funcionalidade")
@Getter
@Setter
public class UsuarioFuncionalidade {

    @EmbeddedId
    private UsuarioFuncionalidadeId id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_funcionalidade", insertable = false, updatable = false)
    private Funcionalidade funcionalidade;

    @Column(name = "leitura", nullable = false)
    private Boolean leitura;

    @Column(name = "escrita", nullable = false)
    private Boolean escrita;
}
