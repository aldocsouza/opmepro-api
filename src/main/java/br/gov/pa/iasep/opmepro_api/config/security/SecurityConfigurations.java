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
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/cadastrar-usuario").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/credenciado/credenciados").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/credenciado/atualizar-credenciado").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/credenciado/cadastrar-credenciado").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/funcionalidade/funcionalidades").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/funcionalidade/funcionalidade-usuarios").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/funcionalidade/cadastrar-funcionalidade").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/funcionalidade/atualizar-funcionalidade").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuario/usuarios").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuario/usuario-funcionalidades").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuario/usuario-basico").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuario/usuario-credenciado").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/usuario/atualizar-usuario").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/usuario-funcionalidades/funcionalidades-usuario").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuario-funcionalidades/atribuir-funcionalidades").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/auth/logout").permitAll()

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
