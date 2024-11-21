package com.whitemap.whitespringboot3.web.dto;

public class UserRegistrationDTO {
    //必要
    private String email;
    private String userName;
    private String password;
    //非必要
    private String birthday;
    private String gender;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "Name:"+userName+" "+"Password:"+password+" "+"Email:"+email;
    }
}
