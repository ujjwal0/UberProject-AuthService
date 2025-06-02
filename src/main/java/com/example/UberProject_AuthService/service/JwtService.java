package com.example.UberProject_AuthService.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService implements CommandLineRunner {

     @Value("${jwt.expiry}")
     private int expiry;

     @Value("${jwt.secret}")
     private String SECRET;

     public String createToken(Map<String,Object> payload,String userName){
         Date now=new Date();
         Date expiryDate=new Date(now.getTime()+expiry*1000L);
         SecretKey Key= Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
         return Jwts.builder()
                 .claims(payload)
                 .issuedAt(new Date(System.currentTimeMillis()))
                 .expiration(expiryDate)
                 .subject(userName)
                 .signWith(Key)
                 .compact();
     }

    @Override
    public void run(String... args) throws Exception {
        Map<String,Object>mp=new HashMap<>();
        mp.put("email","abc.@email.com");
        mp.put("phoneNumber","888888888");
        String result =createToken(mp,"sanket");
        System.out.println("Generated Token is ->"+result);
    }
}
