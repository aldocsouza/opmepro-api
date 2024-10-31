package br.gov.pa.iasep.opmepro_api.config.security;

import br.gov.pa.iasep.opmepro_api.base.User;
import br.gov.pa.iasep.opmepro_api.model.entities.AgentUser;
import br.gov.pa.iasep.opmepro_api.model.entities.RegularUser;
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

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTCreator.Builder jwtBuilder = JWT.create()
                    .withIssuer("opmepro-api")
                    .withSubject(user.getUsername())
                    .withClaim("name", user.getName())
                    .withClaim("cpf", user.getCpf())
                    .withClaim("phone", user.getPhone())
                    .withClaim("email", user.getEmail())
                    .withClaim("role", user.getRole().toString())
                    .withClaim("status", user.getStatus())
                    .withExpiresAt(generateExpirationDate());

                    if (user instanceof AgentUser) {
                        AgentUser agentUser = (AgentUser) user;
                        jwtBuilder.withClaim("code", agentUser.getCode());
                        jwtBuilder.withClaim("registry", agentUser.getRegistry());
                        jwtBuilder.withClaim("affiliation", agentUser.getAffiliation());

                        if (user.getLastSession() != null) {
                            jwtBuilder.withClaim("lastSession", user.getLastSession().toString());
                        }
                    } else if (user instanceof RegularUser) {
                        RegularUser regularUser = (RegularUser) user;
                        jwtBuilder.withClaim("code", regularUser.getCode());

                        if (user.getLastSession() != null) {
                            jwtBuilder.withClaim("lastSession", user.getLastSession().toString());
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
