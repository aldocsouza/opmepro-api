package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseSegurado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "segurado")
public class Segurado extends BaseSegurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "segurado")
    private List<Solicitacao> solicitacaoList = new ArrayList<>();

    @OneToMany(mappedBy = "segurado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeguradoHistorico> seguradoHistoricoList = new ArrayList<>();

}
