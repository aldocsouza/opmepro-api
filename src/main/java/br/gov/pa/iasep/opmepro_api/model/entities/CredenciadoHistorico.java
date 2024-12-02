package br.gov.pa.iasep.opmepro_api.model.entities;

import br.gov.pa.iasep.opmepro_api.base.BaseCredenciado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_credenciados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CredenciadoHistorico extends BaseCredenciado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime dataAlteracao;

    @Column(name = "usuario_alteracao", nullable = false)
    private Integer usuarioAlteracao;

    @Column(name = "id_tipo", nullable = false)
    private Integer tipoCredenciado;

    @ManyToOne
    @JoinColumn(name = "id_credenciado", nullable = false)
    private Credenciado credenciado;

}
