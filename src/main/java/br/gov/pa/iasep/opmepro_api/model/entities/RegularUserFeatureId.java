package br.gov.pa.iasep.opmepro_api.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegularUserFeatureId implements Serializable {
    private Integer userCode;
    private Integer featureCode;
}
