package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseSolicitacao {

    @Column(name = "medico", nullable = false)
    protected String medico;

    @Column(name = "observacao")
    protected String observacao;

    @Column(name = "status")
    protected Boolean status;

    @Column(name = "data_solicitacao", nullable = false)
    protected LocalDateTime dataSolicitacao;

    @Column(name = "num_processo", nullable = false)
    protected String numProcesso;

    @Column(name = "termo_adesao", nullable = false)
    protected String termoAdesao;

    @Column(name = "grau_parentesco", nullable = false)
    protected String grauParentesco;

    public BaseSolicitacao(String medico, String observacao, Boolean status, LocalDateTime dataSolicitacao, String numProcesso, String termoAdesao, String grauParentesco) {
        this.medico = medico;
        this.observacao = observacao;
        this.status = status;
        this.dataSolicitacao = dataSolicitacao;
        this.numProcesso = numProcesso;
        this.termoAdesao = termoAdesao;
        this.grauParentesco = grauParentesco;
    }

    public BaseSolicitacao() {
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getNumProcesso() {
        return numProcesso;
    }

    public void setNumProcesso(String numProcesso) {
        this.numProcesso = numProcesso;
    }

    public String getTermoAdesao() {
        return termoAdesao;
    }

    public void setTermoAdesao(String termoAdesao) {
        this.termoAdesao = termoAdesao;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }
}
