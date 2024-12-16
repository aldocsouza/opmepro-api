package br.gov.pa.iasep.opmepro_api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/api/credenciados/resumidos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/credenciados/detalhado/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/funcionalidades/resumidos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/funcionalidades/detalhado/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuarios/resumidos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuarios/detalhado/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuarios/{id}/credenciado").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuarios/perfis").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuarios/situacao-usuario").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuarios-funcionalidades/{id}/funcionalidades").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/solicitacoes/resumidas").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/solicitacoes/{id}/detalhado").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/segurados/detalhados").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/segurados/segurado").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/materiais/resumidos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/materiais/detalhado").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/procedimentos/resumidos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/procedimentos/detalhado").permitAll()

                        .requestMatchers(HttpMethod.PUT, "/api/auth/logout/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/credenciados/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/funcionalidades/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/usuarios/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/segurados/atualizar/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/materiais/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/procedimentos/{id}").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/credenciados/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/funcionalidades/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuarios-funcionalidades/atribuir").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/solicitacoes/registrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/segurados/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/materiais/cadastrar").permitAll()

                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
