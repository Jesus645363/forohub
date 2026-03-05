package com.alura.forohub.security;

import com.alura.forohub.domain.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    private final String secret = "forohub-secret";

    public String generarToken(Usuario usuario) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("forohub")
                .withSubject(usuario.getUsername())
                .withExpiresAt(fechaExpiracion())
                .sign(algorithm);
    }

    public String getSubject(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.require(algorithm)
                .withIssuer("forohub")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant fechaExpiracion() {
        return Instant.now().plus(2, ChronoUnit.DAYS);
    }
}