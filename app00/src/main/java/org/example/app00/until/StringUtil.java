package org.example.app00.until;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class StringUtil {
    public static String getRandomNumber(int len){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(Math.round(Math.random() * 9));
        }
        return sb.toString();
    }

    //md5加密
    public static String getMD5(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(messageDigest);
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b:bytes) {
            sb.append(String.format("%02x",b));
        }
        return sb.toString();
    }

    public static String md5Password(String password,String salt,int count){
        for (int i = 0; i < count; i++) {
            password = getMD5(password + salt);
        }
        return password;
    }
    public static String uuid (){
        return UUID.randomUUID().toString().replace("-","");
    }
}
