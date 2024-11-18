package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_procedimentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historico_procedimentos")
    private Integer id;

    @Column(name = "codigo", nullable = false)
    private String code;

    @Column(name = "dsc_procedimento", nullable = false)
    private String description;

    @Column(name = "valor", nullable = false)
    private Double value;

    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime modificationDate;
}
