package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseCredenciado {

    @Column(name = "matricula", nullable = false, length = 45)
    protected String matricula;

    @Column(name = "razao_social", length = 120)
    protected String razaoSocial;

    @Column(name = "nome_fantasia", nullable = false, length = 120)
    protected String nomeFantasia;

    @Column(name = "cnpj", length = 18)
    protected String cnpj;

    @Column(name = "cpf", length = 18)
    protected String cpf;

    @Column(name = "num_contrato", nullable = false, length = 45)
    protected String numContrato;

    @Column(name = "status", nullable = false)
    protected Boolean status;

    @Column(name = "apelido", length = 50)
    protected String apelido;

    public BaseCredenciado(String matricula, String razaoSocial, String nomeFantasia, String cnpj, String cpf, String numContrato, Boolean status, String apelido) {
        this.matricula = matricula;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.numContrato = numContrato;
        this.status = status;
        this.apelido = apelido;
    }

    public BaseCredenciado() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(String numContrato) {
        this.numContrato = numContrato;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
