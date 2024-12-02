package br.gov.pa.iasep.opmepro_api.model.entities;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditagemId implements Serializable {

    private Integer idUsuario;
    private Integer idSolicitacao;

}
