package com.star;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: JwtTest
 * @Date: 2024/11/27 16:36
 * @Author: 聂建强
 * @Description:
 */
public class JwtTest {

    /**
     * 测试JWT生成
     */
    @Test
    public void testGen(){
        // 生成jwt的代码
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        // 生成JWT的代码
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*3))
                .sign(Algorithm.HMAC256("itheima"));  // 指定算法，配置秘钥
        System.out.println(token);
    }

    /**
     * 测试JWT解析
     */
    @Test
    public void parseToken(){
        // 生成jwt的代码
        String token  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MzYwNjk4ODN9" +
                ".iYby0UTeiEulmAOiVc-GL7i0gSpoQwNF9eOhvCoYNIY";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();  // JWT验证器

        DecodedJWT decodedJWT = jwtVerifier.verify(token);  // 验证token，生成一个解析后的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();  // 获取所有载荷
        System.out.println(claims.get("user"));  // 获取键为"user"的载荷

        // 如果篡改了头部和载荷部分的数据，那么验证失败
        // 如果秘钥改了，验证失败
        // token过期，验证失败

    }
}
