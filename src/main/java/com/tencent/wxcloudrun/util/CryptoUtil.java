package com.tencent.wxcloudrun.util;

import cn.hutool.crypto.symmetric.AES;
import org.springframework.util.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoUtil {

    private static final String MODE = "CBC";
    private static final String PADDING = "PKCS7Padding";
    private static final String KEY = "Gao2022cm0312dai";
    private static final String IV = "Gao2022cm0312dcd";

    /**
     * 加密
     * @param data data
     * @return String
     */
    public static String encryption(String data){
        AES aes = new AES(MODE, PADDING,
                // 密钥，不可更改 (16位)
                KEY.getBytes(),
                // iv加盐
                IV.getBytes());
        // 加密为16进制表示
        return aes.encryptHex(data);
    }

    /**
     * 解密
     * @param data data
     * @return String
     */
    public static String decryption(String data){
        AES aes = new AES(MODE, PADDING,
                // 密钥，不可更改 (16位)
                KEY.getBytes(),
                // iv加盐
                IV.getBytes());
        // 加密为16进制表示
        return aes.decryptStr(data);
    }




}
