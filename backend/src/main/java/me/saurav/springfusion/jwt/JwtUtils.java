package me.saurav.springfusion.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {

    private String jwtSecret = "alkNPjvhtxhfhcuD87MrffaOd6OldF8RH2/JJR6ngNY=";

    @Value("#{${spring.app.jwt.expiretimeinmin:2} * 1000 * 60}")
    private int jwtExpireTime;

    public String getJwtFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String generateTokenFromUsername(UserDetails userDetails) {
        String username = userDetails.getUsername();
        return Jwts.builder().subject(username).issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpireTime)).signWith(key()).compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build().parseSignedClaims(token)
                .getPayload().getSubject();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken) {
        Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(authToken);

        return true;
    }
}
