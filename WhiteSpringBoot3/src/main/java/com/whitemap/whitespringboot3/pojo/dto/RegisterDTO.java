package com.whitemap.whitespringboot3.pojo.dto;

import jakarta.validation.constraints.NotBlank;

public class RegisterDTO {
    private String username;
    private String password;
    private String email;

    public RegisterDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
