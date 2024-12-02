package br.gov.pa.iasep.opmepro_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_sessao_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioHistoricoSessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_login", nullable = false)
    private LocalDateTime dataLogin;

    @Column(name = "data_logout")
    private LocalDateTime dataLogout;

    @Column(name = "endereco_ip", nullable = false, length = 15)
    private String enderecoIp;

    @Column(name = "data_alteracao", nullable = false, length = 15)
    private LocalDateTime dataAlteracao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

}
