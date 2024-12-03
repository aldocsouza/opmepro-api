package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "auditagem")
public class Auditagem {

    @EmbeddedId
    private AuditagemId id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_solicitacao", insertable = false, updatable = false)
    private Solicitacao solicitacao;

    @Column(name = "data_auditagem", nullable = false)
    private LocalDateTime dataAuditagem;

}
