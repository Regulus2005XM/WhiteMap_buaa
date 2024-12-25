package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.Common.SubjectType;
import com.whitemap.whitespringboot3.DB.pojo.comments.CommentSubjectPOJO;
import org.apache.ibatis.javassist.tools.rmi.ObjectNotFoundException;

public interface ISubjectService {
    CommentSubjectPOJO add(Integer ownerId, SubjectType type);

    void updateCount(Integer objId, boolean b) throws ObjectNotFoundException;

    boolean subjectExist(Integer objId, Integer objType);

    void delete(Integer subjectId);
}
