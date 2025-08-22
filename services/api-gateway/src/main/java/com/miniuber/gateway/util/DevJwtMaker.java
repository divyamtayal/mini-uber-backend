package com.miniuber.gateway.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

public class DevJwtMaker {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: DevJwtMaker <BASE64_SECRET> [subject]");
            System.exit(1);
        }
        String base64Secret = args[0];
        String sub = (args.length > 1) ? args[1] : "user-123";

        byte[] keyBytes = Decoders.BASE64.decode(base64Secret);
        if (keyBytes.length < 32) {
            throw new IllegalArgumentException("Secret must be >= 32 bytes (256 bits) when Base64-decoded.");
        }
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        Instant now = Instant.now();
        String token = Jwts.builder()
                .setSubject(sub)
                .setIssuer("mini-uber")
                .setAudience("mini-uber-clients")
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(3600)))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        System.out.println(token);
    }
}
