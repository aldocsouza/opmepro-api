package br.gov.pa.iasep.copme_api.infra.security;

import br.gov.pa.iasep.copme_api.model.entities.User;
import com.auth0.jwt.JWT;
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
            String token = JWT.create()
                    .withIssuer("copme-api")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withClaim("fullName", user.getFullName())
                    .withClaim("cpf", user.getCpf())
                    .withClaim("registration", user.getRegistration())
                    .withClaim("phone", user.getPhone())
                    .withClaim("role", user.getRole().toString())
                    .withClaim("email", user.getEmail())
                    .withClaim("situation", user.getSituation())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);

            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro na geração do token");
        }
    }

    public String validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("copme-api")
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
