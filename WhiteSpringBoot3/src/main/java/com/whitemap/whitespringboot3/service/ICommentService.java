package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.Common.SubjectType;
import com.whitemap.whitespringboot3.entity.Comment;
import com.whitemap.whitespringboot3.web.dto.Comment.SendCommentDTO;

public interface ICommentService {

    boolean commentExist(Integer objId, Integer objType, Integer root, Integer parent);

    Comment add(SendCommentDTO dto);

    void deleteSubject(Integer subjectId, SubjectType site);
}
