package com.example.memoapi.Service;

import io.jsonwebtoken.Jwts;
import lombok.Data;
import lombok.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey(){
        byte[] decodedKey = Base64.getDecoder().decode(secret.getBytes());
        return
    }

    public String generateToken(String username){
        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey(),Jwts.SIG.HS256)
            .compact();
    }
}
