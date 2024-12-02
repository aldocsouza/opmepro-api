package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseSegurado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_segurado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguradoHistorico extends BaseSegurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime dataAlteracao;

    @Column(name = "usuario_alteracao", nullable = false)
    private Integer usuarioAlteracao;

    @ManyToOne
    @JoinColumn(name = "segurado_id")
    private Segurado segurado;

}
