package com.whitemap.whitespringboot3.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHashUtil {

    // 使用SHA-256算法
    private static final String ALGORITHM = "SHA-256";

    // 将密码转换为哈希值
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
        byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        // 使用Base64编码将字节数组转换为字符串，以便于存储和比较
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    // 验证输入的密码是否与存储的哈希值匹配
    public static boolean checkPassword(String rawPassword, String hashedPassword) throws NoSuchAlgorithmException {
        String hashedInput = hashPassword(rawPassword);
        return hashedInput.equals(hashedPassword);
    }
}
