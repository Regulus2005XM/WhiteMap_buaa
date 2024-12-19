package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.DB.dao.UserDAO;
import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import com.whitemap.whitespringboot3.util.PasswordHashUtil;
import com.whitemap.whitespringboot3.util.TimeUtil;
import com.whitemap.whitespringboot3.web.dto.User.RegisterDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService implements IUserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public UserPOJO add(RegisterDTO dto) {
        UserPOJO user = new UserPOJO();
        BeanUtils.copyProperties(dto, user);
        //加密密码
        try {
            user.setPassword(PasswordHashUtil.hashPassword(dto.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        //上次改名时间设为Unix时间戳原点
        user.setLastNameChange(TimeUtil.getUnixEpochTimestamp());
        userDAO.save(user);
        return user;
    }

    @Override
    public UserPOJO get(String account) {
        return userDAO.findByAccount(account);
    }

    @Override
    public UserPOJO get(Integer id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    public Boolean accountExists(String account) {
        return userDAO.findByAccount(account) != null;
    }

    @Override
    public void save(UserPOJO pojo) {
        userDAO.save(pojo);
    }
}
