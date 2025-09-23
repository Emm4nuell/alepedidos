package br.com.alepedidos.domain.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtTokenService {
    private static final String SECRET_KEY = "chave-super-secreta-para-gerar-token-256bits";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // Gerar token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // usuário
                .setIssuedAt(new Date(System.currentTimeMillis())) // data de criação
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // expiração
                .signWith(key,
                        SignatureAlgorithm.HS256) // assinar com chave secreta
                .compact();
    }

    // Pegar usuário (subject) do token
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // Verificar se o token ainda é válido
    public boolean isTokenValid(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    // Internos
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration()
                .before(new Date());
    }
}
