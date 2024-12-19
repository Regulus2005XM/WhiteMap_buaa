package com.whitemap.whitespringboot3.DB.dao;

import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends CrudRepository<UserPOJO, Integer> {
    UserPOJO findByUsername(String username);

    UserPOJO findByAccount(String account);
}
