package br.gov.pa.iasep.opmepro_api.base;

import br.gov.pa.iasep.opmepro_api.model.entities.Feature;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
public abstract class UserFeature {

    @Id
    @ManyToOne
    @JoinColumn(name = "funcionalidade_cod_funcionalidade", nullable = false)
    private Feature featureCode;

    @Column(name = "leitura", nullable = false)
    private Boolean reading;

    @Column(name = "escrita", nullable = false)
    private Boolean writing;

    public UserFeature(Feature featureCode, Boolean reading, Boolean writing) {
        this.featureCode = featureCode;
        this.reading = reading;
        this.writing = writing;
    }

    public Feature getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(Feature featureCode) {
        this.featureCode = featureCode;
    }

    public Boolean getReading() {
        return reading;
    }

    public void setReading(Boolean reading) {
        this.reading = reading;
    }

    public Boolean getWriting() {
        return writing;
    }

    public void setWriting(Boolean writing) {
        this.writing = writing;
    }
}
