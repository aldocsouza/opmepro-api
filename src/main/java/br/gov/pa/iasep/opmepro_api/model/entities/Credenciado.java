package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseCredenciado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "credenciados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credenciado extends BaseCredenciado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private CredenciadoTipo tipoCredenciado;

    @OneToMany(mappedBy = "credenciado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "credenciado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CredenciadoHistorico> credenciadoHistoricoList = new ArrayList<>();

    @OneToMany(mappedBy = "credenciado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitacao> solicitacaoList = new ArrayList<>();
}
