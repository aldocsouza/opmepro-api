package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseAccredited;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "credenciados")
@Getter
@Setter
public class Accredited extends BaseAccredited {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_credenciados", nullable = false)
    private Integer code;

    @OneToMany(mappedBy = "accredited", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegularUser> regularUsers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "credenciados_material_opme",
            joinColumns = @JoinColumn(name = "credenciados_cod_credenciados", referencedColumnName = "cod_credenciados"),
            inverseJoinColumns = @JoinColumn(name = "material_opme_cod_material_opme", referencedColumnName = "cod_material_opme")
    )
    private List<Material> materials = new ArrayList<>();

    public Accredited(Integer code, String registry, String corporateName, String businessName, String cnpj, String contractNumber, String nickName, Boolean supplier) {
        super(registry, corporateName, businessName, cnpj, contractNumber, nickName, supplier);
        this.code = code;
    }

    public Accredited(String registry, String corporateName, String businessName, String cnpj, String contractNumber, String nickName, Boolean supplier) {
        super(registry, corporateName, businessName, cnpj, contractNumber, nickName, supplier);
    }

    public Accredited() {
        super();
    }

}
