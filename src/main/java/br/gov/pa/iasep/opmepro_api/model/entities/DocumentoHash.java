package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "documento_hash")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoHash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hash_documento", nullable = false)
    private String hashDocumento;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "tipo_documento", nullable = false)
    private String tipoDocumento;

    @Column(name = "cnpj")
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "id_solicitacao")
    private Solicitacao solicitacao;

}
