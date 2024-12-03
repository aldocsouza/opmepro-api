package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditagemId implements Serializable {

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_solicitacao")
    private Integer idSolicitacao;
}
