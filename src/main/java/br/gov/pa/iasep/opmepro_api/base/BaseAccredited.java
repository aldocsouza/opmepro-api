package br.gov.pa.iasep.opmepro_api.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
public class BaseAccredited {

    @Column(name = "matricula", nullable = false, length = 45)
    private String registry;

    @Column(name = "razao_social", nullable = false, length = 120)
    private String corporateName;

    @Column(name = "nome_fantasia", nullable = false, length = 120)
    private String businessName;

    @Column(name = "cnpj", nullable = false, length = 18)
    private String cnpj;

    @Column(name = "num_contrato", nullable = false, length = 45)
    private String contractNumber;

    @Column(name = "apelido", length = 50)
    private String nickName;

    @Column(name = "fornecedor_material_opme", nullable = false)
    private Boolean isSupplier;

    public BaseAccredited(String registry, String corporateName, String businessName, String cnpj, String contractNumber, String nickName, Boolean isSupplier) {
        this.registry = registry;
        this.corporateName = corporateName;
        this.businessName = businessName;
        this.cnpj = cnpj;
        this.contractNumber = contractNumber;
        this.nickName = nickName;
        this.isSupplier = isSupplier;
    }

    public BaseAccredited() {
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getSupplier() {
        return isSupplier;
    }

    public void setSupplier(Boolean supplier) {
        isSupplier = supplier;
    }
}
