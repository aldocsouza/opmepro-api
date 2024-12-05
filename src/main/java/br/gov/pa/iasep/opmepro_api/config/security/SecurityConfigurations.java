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
                        .requestMatchers(HttpMethod.GET, "/api/usuarios-funcionalidades/{id}/funcionalidades").permitAll()

                        .requestMatchers(HttpMethod.PUT, "/api/auth/logout/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/credenciados/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/funcionalidades/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/usuarios/{id}").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/credenciados/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/funcionalidades/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuarios-funcionalidades/atribuir").permitAll()
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
