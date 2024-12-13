package com.whitemap.whitespringboot3.DB.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.DialectOverride;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Table(name = "tb_user")
@Entity
public class UserPOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column
    private Integer age;
    @Column
    private Integer gender;

    public Integer getId(){
        return id;
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

    public Integer getAge() {
        return age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
