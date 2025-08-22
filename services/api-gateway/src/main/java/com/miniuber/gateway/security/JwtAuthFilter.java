package com.miniuber.gateway.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.util.List;

@Component
public class JwtAuthFilter implements WebFilter {

    private final SecretKey key;
    private final String issuer;
    private final String audience;

    public JwtAuthFilter(
            @Value("${security.jwt.secret}") String base64Secret,
            @Value("${security.jwt.issuer:mini-uber}") String issuer,
            @Value("${security.jwt.audience:mini-uber-clients}") String audience) {

        byte[] keyBytes = Decoders.BASE64.decode(base64Secret);
        if (keyBytes.length < 32) {
            throw new IllegalArgumentException("JWT secret must be at least 256 bits (Base64 of >=32 bytes).");
        }
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.issuer = issuer;
        this.audience = audience;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String auth = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (auth == null || !auth.startsWith("Bearer ")) {
            return chain.filter(exchange);
        }
        String token = auth.substring(7);

        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .requireIssuer(issuer)
                    .requireAudience(audience)
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    jws.getBody().getSubject(),
                    null,
                    List.of(new SimpleGrantedAuthority("ROLE_USER"))
            );

            return chain.filter(exchange)
                    .contextWrite(ReactiveSecurityContextHolder.withAuthentication(authentication));

        } catch (JwtException e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }
}
