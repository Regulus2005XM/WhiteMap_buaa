package com.whitemap.whitespringboot3.web.dto.User;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nullable;
import java.sql.Timestamp;

public class UserInfoDTO {

    private Integer id;
    @Nullable
    private String username;
    @Nullable
    private Timestamp birthday;
    @Nullable
    private Integer gender;
    @Nullable
    private String description;
    @Nullable
    private MultipartFile imageFile;

    public UserInfoDTO(Integer id,@Nullable String username, @Nullable Timestamp birthday, @Nullable Integer gender, @Nullable String description, @Nullable MultipartFile imageFile) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.gender = gender;
        this.description = description;
        this.imageFile = imageFile;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public String getUsername() {
        return username;
    }

    @Nullable
    public Timestamp getBirthday() {
        return birthday;
    }

    @Nullable
    public Integer getGender() {
        return gender;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public MultipartFile getImageFile() {
        return imageFile;
    }
}
