package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.pojo.UserPOJO;
import com.whitemap.whitespringboot3.pojo.dto.RegisterDTO;

public interface IUserService {
    /**
     * 插入用户
     *
     * @param dto 注册/登录数据
     * @return
     */
    UserPOJO add(RegisterDTO dto);

    UserPOJO get(String userName);
}
