package com.whitemap.whitespringboot3.dao;

import com.whitemap.whitespringboot3.pojo.UserPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<UserPOJO, Integer> {
    UserPOJO findByUsername(String username);
}
