package cybersoft.javabackend.java16giracanglv.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
@Slf4j
@Component
public class JwtHelper {
    private String key = "secretkey";

    public String generateJwtToken(String username) {
        Date currentDate = new Date();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();

    }

    public boolean validate(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(jwtToken);
            return true;
        } catch (UnsupportedJwtException e1) {
            log.error("JWT Token is Unsupported {}", e1);

        } catch (
                MalformedJwtException e2) {
            log.error("JWT Token is Malformed {}", e2);

        } catch (SignatureException e3) {
            log.error("JWT Token has wrong SignatureAlgorithm {}", e3);

        } catch (
                ExpiredJwtException e4) {
            log.error("JWT Token is Expired {}", e4);


        } catch (IllegalArgumentException e5) {
            log.error("JWT Token is IllegalArgument {}", e5);

        }
        return false;

    }
}
