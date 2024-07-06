package org.example.app00.until;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

/**
 * @program: dayunhui
 * @Name JWTUtil
 * @description:
 * @author: kinglee
 * @create: 2023-07-02 15:38
 * @Version 1.0
 */
public class JWTUtil {

    private static final long EXP = 24 * 60 * 60 * 1000;//过期时间

    /**
     * 生成token
     * @param phone  账号信息
     * @param secret  秘钥
     * @return 生成的token
     */
    public static String sign(String phone,String secret){
        Date date = new Date(System.currentTimeMillis() + EXP);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        //附带username信息的token
        return JWT.create().withClaim("phone",phone).withExpiresAt(date).sign(algorithm);
    }

    /**
     * 从token中获取账号
     * @param token
     * @return
     */
    public static String getPhone(String token){
        try {
            //解码token
            DecodedJWT decodedJWT = JWT.decode(token);
            return decodedJWT.getClaim("phone").asString();
        }catch (JWTDecodeException e){
            return null;
        }
    }

    /**
     * 校验token是否正确
     * @param token
     * @param phone
     * @param secret
     * @return
     */
    public static boolean verify(String token,String phone,String secret){
        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withClaim("phone", phone).build();
            DecodedJWT verify = jwtVerifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 检查token是否过期
     * @param token
     * @return
     */
    public static boolean isExpires(String token){
        return System.currentTimeMillis() > JWT.decode(token).getExpiresAt().getTime();
    }
}
