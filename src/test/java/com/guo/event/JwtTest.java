package com.guo.event;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {


    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        String token =  JWT.create()
                .withClaim("user",claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))//添加过期时间
                .sign(Algorithm.HMAC256("itheima"));
        System.out.println(token);
    }


    @Test
    public void testParse(){
         String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MDEyMzE3NTF9.sOqCpoecjqnmlx08oVB99apmZ9ydQjaQGMiCVGCyP20";
         JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();
         DecodedJWT verify = jwtVerifier.verify(token);
        Map<String, Claim> claims = verify.getClaims();
        System.out.println(claims.get("user"));


    }
}
