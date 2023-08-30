package com.example.ncre_system_idea.utils;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class AesUtil {

    // 加密算法AES
    public static final String KEY_ALGORITHM = "AES";

    //编码方式
    public static final String CODE_TYPE = "UTF-8";

    //填充类型 AES/ECB/PKCS5Padding   AES/ECB/ISO10126Padding
    public static final String AES_TYPE = "AES/ECB/PKCS5Padding";

    /**
     * 自定义内容加盐，生成AES秘钥
     */
    public static String generateAESKey(){
        // 生成6位的随机加盐字符串
        String salt = getSalt(6);
        // 对加盐字符串进行MD5加密，并截取中间16位作为AES秘钥
        return DigestUtils.md5Hex(salt).substring(8, 24);
    }

    /**
     * 随机生成加盐字符串
     */
    public static String getSalt(int n){
        char[] chars = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "1234567890!@#$%^&*()_+").toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for(int i = 0; i < n; i++){
            // 从字符数组中随机选取一个字符，添加到加盐字符串中
            stringBuilder.append(chars[random.nextInt(chars.length)]);
        }
        // 返回生成的加盐字符串
        return stringBuilder.toString();
    }

    /**
     * 加密
     * @param clearText 明文
     * @param aesKey AES秘钥
     * @return 加密串
     */
    public static String encryptAes(String clearText, String aesKey) {
        try {
            // 将AES秘钥转换为SecretKeySpec对象
            SecretKeySpec key = new SecretKeySpec(aesKey.getBytes(StandardCharsets.UTF_8), "AES");
            // 创建AES加密器
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // 初始化加密器，设置模式为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 对明文进行加密
            byte[] encryptedData = cipher.doFinal(clearText.getBytes(StandardCharsets.UTF_8));
            // 对加密后的数据进行Base64编码，并返回编码后的字符串
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            throw new RuntimeException("加密失败", e);
        }
    }

    /**
     * 解密
     * @param encryptText 密文
     * @param aesKey AES秘钥
     * @return 解密串
     */
    public static String decryptAes(String encryptText, String aesKey) {
        try {
            // 对密文进行Base64解码，得到加密后的字节数组
            byte[] byteMi = Base64.getDecoder().decode(encryptText);
            // 将AES秘钥转换为SecretKeySpec对象
            SecretKeySpec key = new SecretKeySpec(aesKey.getBytes(StandardCharsets.UTF_8), "AES");
            // 创建AES解密器
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // 初始化解密器，设置模式为解密模式
            cipher.init(Cipher.DECRYPT_MODE, key);
            // 对加密后的字节数组进行解密
            byte[] decryptedData = cipher.doFinal(byteMi);
            // 将解密后的字节数组转换为字符串，并返回该字符串
            return new String(decryptedData, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("解密失败", e);
        }
    }

    public static void main(String[] args) {
        // 生成AES秘钥
        String aesKey = generateAESKey();
        // 待加密的字符串
        String json = "中文，abc,！@#";

        //加密
        System.out.println("字符串：" + json);
        String encrypt = encryptAes(json, aesKey);
        System.out.println("加密后字符串：" + encrypt);

        //私钥解密
        System.out.println("解密后字符串：" + decryptAes(encrypt, aesKey));
    }
}