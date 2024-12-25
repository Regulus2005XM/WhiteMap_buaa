package com.whitemap.whitespringboot3.DB.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.DialectOverride;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Timestamp;

@Table(name = "tb_user")
@Entity
public class UserPOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "account")
    private String account;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "user_name")
    private String username;
    @Column(name = "birthday")
    private Timestamp birthday;
    @Column
    private Integer gender;
    @Column
    private String description;
    @Column(name = "image_url")
    private String imageURL;
    @Column(name = "last_name_change")
    private Timestamp lastNameChange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Timestamp getLastNameChange() {
        return lastNameChange;
    }

    public void setLastNameChange(Timestamp lastNameChange) {
        this.lastNameChange = lastNameChange;
    }
}
