package kr.co.todoctodoc_back._core.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import kr.co.todoctodoc_back.user.User;

import java.time.Instant;

public class JwtTokenUtils {

    public static String create(User user){
        String jwt = JWT.create()
                .withSubject("project-key")
                .withClaim("id", user.getUserId())
                .withClaim("username", user.getUsername())
                .withExpiresAt(Instant.now().plusMillis(1000*60*60*24*36500L))
                .sign(Algorithm.HMAC512("final"));
        return "Bearer " + jwt;
    }

    public static DecodedJWT verify(String jwt) throws SignatureVerificationException, TokenExpiredException {
        jwt = jwt.replace("Bearer ", "");

        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("final"))
                .build().verify(jwt);
        return decodedJWT;
    }

    public static String extractUserId(String token) {
        DecodedJWT decodedJWT = verify(token);
        return decodedJWT.getClaim("id").asString();
    }
}