package org.example.ecommerce.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;


@Service
public class JwtService {

    private final String SECRET = "nodomingoeulisuacartaimensadizendoqueiasemo";

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String getEmail(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
