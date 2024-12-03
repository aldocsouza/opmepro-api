package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseUsuario {

    @Column(name = "nome", nullable = false, length = 100)
    protected String nome;

    @Column(name = "cpf", nullable = false, length = 11)
    protected String cpf;

    @Column(name = "login", nullable = false, length = 20)
    protected String username;

    @Column(name = "senha", nullable = false, length = 100)
    protected String password;

    @Column(name = "telefone", nullable = false, length = 11)
    protected String telefone;

    @Column(name = "email", nullable = false, length = 155)
    protected String email;

    @Column(name = "situacao", nullable = false)
    protected Boolean situacao;

    public BaseUsuario(String nome, String cpf, String username, String password, String telefone, String email, Boolean situacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.username = username;
        this.password = password;
        this.telefone = telefone;
        this.email = email;
        this.situacao = situacao;
    }

    public BaseUsuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }
}
