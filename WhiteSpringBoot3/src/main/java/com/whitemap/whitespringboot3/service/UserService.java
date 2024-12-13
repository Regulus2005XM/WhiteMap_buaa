package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.DB.dao.UserDAO;
import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import com.whitemap.whitespringboot3.web.dto.RegisterDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserPOJO add(RegisterDTO dto) {
        UserPOJO user = new UserPOJO();
        BeanUtils.copyProperties(dto, user);
        userDAO.save(user);
        return user;
    }

    @Override
    public UserPOJO get(String userName) {
        return userDAO.findByUsername(userName);
    }
}
