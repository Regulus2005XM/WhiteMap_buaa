package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import com.whitemap.whitespringboot3.web.dto.User.RegisterDTO;

import java.util.Optional;

public interface IUserService {
    /**
     * 插入用户
     *
     * @param dto 注册/登录数据
     * @return
     */
    UserPOJO add(RegisterDTO dto);

    UserPOJO get(String account);

    UserPOJO get(Integer id);

    Boolean accountExists(String account);

    void save(UserPOJO pojo);
}
