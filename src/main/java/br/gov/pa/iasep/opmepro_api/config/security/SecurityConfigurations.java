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
                        .requestMatchers(HttpMethod.GET, "/api/features/all-features").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/regular/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/regular/users-features").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/regular/users-no-list").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/agents/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/agents/users-features").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/agents/users-no-list").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/accredited/all-accredited").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/agent-features/all-permissions").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/regular-features/all-permissions").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/register-user-agent").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/register-user-regular").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/features/create-feature").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/agent-features/assign-feature").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/regular-features/assign-feature").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/accredited/create-accredited").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/agents/update-no-list").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/regular/update-no-list").permitAll()
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
