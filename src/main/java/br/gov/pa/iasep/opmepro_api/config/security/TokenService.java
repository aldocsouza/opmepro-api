package br.gov.pa.iasep.opmepro_api.config.security;

import br.gov.pa.iasep.opmepro_api.model.entities.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
                    .withClaim("nome", usuario.getNome())
                    .withClaim("cpf", usuario.getCpf())
                    .withClaim("telefone", usuario.getTelefone())
                    .withClaim("email", usuario.getEmail())
                    .withClaim("role", usuario.getPerfil().toString())
                    .withClaim("situacao", usuario.getSituacao())
                    .withExpiresAt(generateExpirationDate());

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
