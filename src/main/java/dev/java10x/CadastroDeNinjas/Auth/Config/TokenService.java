package dev.java10x.CadastroDeNinjas.Auth.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.java10x.CadastroDeNinjas.User.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {
    @Value("$cadastroninja.security.secret")
    private String secret;

    public String generateToken(UserModel user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId", user.getId())
                .withClaim("name", user.getName())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API CadastroNinja")
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            JWTUserData jwtUserData = new JWTUserData(jwt.getClaim("userId").asLong(),
                    jwt.getClaim("name").asString(), jwt.getSubject());
            return Optional.of(jwtUserData);

        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }
}
