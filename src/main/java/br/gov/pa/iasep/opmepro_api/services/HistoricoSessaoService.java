package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.exceptions.NotFoundException;
import br.gov.pa.iasep.opmepro_api.model.entities.Usuario;
import br.gov.pa.iasep.opmepro_api.model.entities.UsuarioHistoricoSessao;
import br.gov.pa.iasep.opmepro_api.repositories.HistoricoSessaoRepository;
import br.gov.pa.iasep.opmepro_api.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class HistoricoSessaoService {

    private final HistoricoSessaoRepository historicoSessaoRepository;
    private final UsuarioRepository usuarioRepository;

    public HistoricoSessaoService(HistoricoSessaoRepository historicoSessaoRepository, UsuarioRepository usuarioRepository) {
        this.historicoSessaoRepository = historicoSessaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void iniciarSessao(Usuario usuario, String ipClient){
        UsuarioHistoricoSessao historyRegularUser = new UsuarioHistoricoSessao(
                LocalDateTime.now(),
                null,
                ipClient,
                null,
                usuario
        );
        historicoSessaoRepository.save(historyRegularUser);
    }

    public void registrarLogout(String logoutDate, Integer code){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        ZonedDateTime utcDateTime = ZonedDateTime.parse(logoutDate, formatter);
        LocalDateTime logout = utcDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();

        Usuario usuario = usuarioRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        UsuarioHistoricoSessao usuarioHistoricoSessao = historicoSessaoRepository.findTopByUsuarioOrderByDataLoginDesc(usuario);
        usuarioHistoricoSessao.setDataLogout(logout);

        historicoSessaoRepository.save(usuarioHistoricoSessao);
    }

}
