package com.whitemap.whitespringboot3.DB.dao;

import com.whitemap.whitespringboot3.DB.pojo.comments.CommentContentPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentContentDAO extends CrudRepository<CommentContentPOJO,Integer> {

}
