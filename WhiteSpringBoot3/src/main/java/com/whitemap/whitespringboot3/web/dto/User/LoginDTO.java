package com.whitemap.whitespringboot3.web.dto.User;

public class LoginDTO {
    private String account;
    private String password;

    public LoginDTO(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
}
