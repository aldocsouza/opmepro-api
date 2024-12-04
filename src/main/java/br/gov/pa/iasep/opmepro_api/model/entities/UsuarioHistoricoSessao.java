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

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public UsuarioHistoricoSessao(Integer id, LocalDateTime dataLogin, LocalDateTime dataLogout, String enderecoIp, Usuario usuario) {
        this.id = id;
        this.dataLogin = dataLogin;
        this.dataLogout = dataLogout;
        this.enderecoIp = enderecoIp;
        this.usuario = usuario;
    }

    public UsuarioHistoricoSessao(LocalDateTime dataLogin, LocalDateTime dataLogout, String enderecoIp, Usuario usuario) {
        this.dataLogin = dataLogin;
        this.dataLogout = dataLogout;
        this.enderecoIp = enderecoIp;
        this.usuario = usuario;
    }

    public UsuarioHistoricoSessao() {
    }
}
