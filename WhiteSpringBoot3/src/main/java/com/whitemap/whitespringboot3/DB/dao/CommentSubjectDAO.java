package com.whitemap.whitespringboot3.DB.dao;

import com.whitemap.whitespringboot3.DB.pojo.comments.CommentSubjectPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentSubjectDAO extends CrudRepository<CommentSubjectPOJO,Integer> {

}
