package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseSegurado {

    @Column(name = "nome_segurado", nullable = false)
    protected String nomeSegurado;

    @Column(name = "cpf", nullable = false)
    protected String cpf;

    @Column(name = "ind_sexo")
    protected String sexo;

    @Column(name = "ind_status")
    protected Boolean status;

    @Column(name = "nom_situacao", nullable = false)
    protected String situacao;

    @Column(name = "nom_municipio", nullable = false)
    protected String municipio;

    @Column(name = "uf")
    protected String uf;

    public BaseSegurado(String nomeSegurado, String cpf, String sexo, Boolean status, String situacao, String municipio, String uf) {
        this.nomeSegurado = nomeSegurado;
        this.cpf = cpf;
        this.sexo = sexo;
        this.status = status;
        this.situacao = situacao;
        this.municipio = municipio;
        this.uf = uf;
    }

    public BaseSegurado() {
    }

    public String getNomeSegurado() {
        return nomeSegurado;
    }

    public void setNomeSegurado(String nomeSegurado) {
        this.nomeSegurado = nomeSegurado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
