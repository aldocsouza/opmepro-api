package br.gov.pa.iasep.opmepro_api.base;

import br.gov.pa.iasep.opmepro_api.model.entities.Feature;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
public abstract class UserFeature {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionalidade_cod_funcionalidade", nullable = false)
    private Feature feature;

    @Column(name = "leitura", nullable = false)
    private Boolean reading;

    @Column(name = "escrita", nullable = false)
    private Boolean writing;

    public UserFeature(Feature feature, Boolean reading, Boolean writing) {
        this.feature = feature;
        this.reading = reading;
        this.writing = writing;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
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
