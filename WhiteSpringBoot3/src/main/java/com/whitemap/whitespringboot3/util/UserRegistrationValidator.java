package com.whitemap.whitespringboot3.util;

import java.util.regex.Pattern;

public class UserRegistrationValidator {

    // 账号规则：仅限字母、数字、下划线、连字符，且长度在5到15个字符之间
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]{5,15}$");
    // 密码规则：仅限字母、数字、下划线、连字符，且长度至少为6-12个字符
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]{6,12}$");
    // 邮箱规则：基本的邮箱格式验证
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public static boolean isValidAccount(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public static boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}