package com.vega.RoomFinder.security;

import com.vega.RoomFinder.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUtil {

    public
     static  String getJWTToken(User user) {
        String secretKey = "mySecretKey";

       List<String> authorities = new ArrayList<>();

        String token = Jwts
                .builder()
                .setId(String.valueOf(user.getId()))
                .setSubject(user.getFullName())
                .claim("authorities", authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
