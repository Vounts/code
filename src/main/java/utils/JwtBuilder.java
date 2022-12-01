package utils;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;


public class JwtBuilder {
    final String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
    public String generateToken(String username, String userId) {

        //Hardcoded but can be in config
       

        try {
            Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                    SignatureAlgorithm.HS256.getJcaName());
            Instant now = Instant.now();
            String jwtToken = Jwts.builder()
                    .claim("username", username)
                    .claim("userId", userId)
                    .setSubject(username)
                    .setId(UUID.randomUUID().toString())
                    .setIssuedAt(Date.from(now))
                    .setExpiration(Date.from(now.plus(60, ChronoUnit.MINUTES)))
                    .signWith(SignatureAlgorithm.HS256, hmacKey)
                    .compact();

            return jwtToken;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public Jws<Claims> parseJwt(String jwtString) {
    String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), 
                                    SignatureAlgorithm.HS256.getJcaName());

    Jws<Claims> jwt = Jwts.parser()
            .setSigningKey(hmacKey)
            .parseClaimsJws(jwtString);
    
    return jwt;
}
}
