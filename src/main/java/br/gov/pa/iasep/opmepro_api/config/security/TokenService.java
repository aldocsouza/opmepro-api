package br.gov.pa.iasep.opmepro_api.config.security;

import br.gov.pa.iasep.opmepro_api.model.entities.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTCreator.Builder jwtBuilder = JWT.create()
                    .withIssuer("opmepro-api")
                    .withSubject(usuario.getUsername())
                    .withClaim("name", usuario.getName())
                    .withClaim("cpf", usuario.getCpf())
                    .withClaim("phone", usuario.getPhone())
                    .withClaim("email", usuario.getEmail())
                    .withClaim("role", usuario.getRole().toString())
                    .withClaim("status", usuario.getStatus())
                    .withExpiresAt(generateExpirationDate());

                    if (usuario instanceof AgentUser) {
                        AgentUser agentUser = (AgentUser) usuario;
                        jwtBuilder.withClaim("code", agentUser.getCode());
                        jwtBuilder.withClaim("registry", agentUser.getRegistry());
                        jwtBuilder.withClaim("affiliation", agentUser.getAffiliation());

                        if (usuario.getLastSession() != null) {
                            jwtBuilder.withClaim("lastSession", usuario.getLastSession().toString());
                        }
                    } else if (usuario instanceof RegularUser) {
                        RegularUser regularUser = (RegularUser) usuario;
                        jwtBuilder.withClaim("code", regularUser.getCode());

                        if (usuario.getLastSession() != null) {
                            jwtBuilder.withClaim("lastSession", usuario.getLastSession().toString());
                        }
                    }

            return jwtBuilder.sign(algorithm);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro na geração do token");
        }
    }

    public String validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("opmepro-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }
}
