package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodificacaoMaterialId implements Serializable {

    @Column(name = "id_solicitacao")
    private Integer idSolicitacao;

    @Column(name = "id_material_opme")
    private Integer idMaterial;

}
