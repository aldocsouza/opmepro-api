package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseUsuario {

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "login", nullable = false, length = 20)
    private String username;

    @Column(name = "senha", nullable = false, length = 100)
    private String password;

    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;

    @Column(name = "email", nullable = false, length = 155)
    private String email;

    @Column(name = "situacao", nullable = false)
    private Boolean situacao;

}
