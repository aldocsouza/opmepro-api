package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.User;
import br.gov.pa.iasep.opmepro_api.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "usuario")
@Getter
@Setter
public class RegularUser extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario", nullable = false, length = 11)
    private Integer code;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "credenciados_cod_credenciados", nullable = false)
    private Accredited accredited;

    @OneToMany(mappedBy = "regularUser", cascade = CascadeType.ALL, orphanRemoval = true)
    List<RegularUserFeature> regularUserFeatures = new ArrayList<>();

    @OneToMany(mappedBy = "regularUser", cascade = CascadeType.ALL)
    List<SessionHistoryRegularUser> sessionHistoryRegularUsers = new ArrayList<>();

    public RegularUser(Integer code, String name, String cpf, String username, String password, String phone, String email, Boolean status, UserRole role, LocalDateTime lastSession, Accredited accredited) {
        super(name, cpf, username, password, phone, email, status, role, lastSession);
        this.code = code;
        this.accredited = accredited;
    }

    public RegularUser(String name, String cpf, String username, String password, String phone, String email, Boolean status, UserRole role, LocalDateTime lastSession, Accredited accredited) {
        super(name, cpf, username, password, phone, email, status, role, lastSession);
        this.accredited = accredited;
    }

    public RegularUser() {
        super();
    }
}
