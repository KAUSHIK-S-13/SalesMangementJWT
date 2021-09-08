package com.sales.management.Util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class GenerateToken {
    public static String generateToken(String userName ,String subject, String userPassword) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setSubject(subject).claim("userName",userName)
                .claim("userPassword",userPassword).signWith(SignatureAlgorithm.HS256,"secret").setIssuedAt(now);
        return builder.compact();
    }
}
