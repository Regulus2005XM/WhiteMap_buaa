package com.whitemap.whitespringboot3.service.impl;

import com.whitemap.whitespringboot3.Common.SubjectType;
import com.whitemap.whitespringboot3.DB.dao.CommentSubjectDAO;
import com.whitemap.whitespringboot3.DB.pojo.comments.CommentSubjectPOJO;
import com.whitemap.whitespringboot3.service.ISubjectService;
import org.apache.ibatis.javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    CommentSubjectDAO commentSubjectDAO;

    @Override
    public boolean subjectExist(Integer objId, Integer objType) {
        CommentSubjectPOJO pojo = commentSubjectDAO.findById(objId).orElse(null);
        return pojo != null && pojo.getType().equals(objType);
    }

    @Override
    public void delete(Integer subjectId) {
        commentSubjectDAO.deleteById(subjectId);
    }

    @Override
    public CommentSubjectPOJO add(Integer ownerId, SubjectType type) {
        CommentSubjectPOJO pojo = new CommentSubjectPOJO();
        pojo.setOwnerId(ownerId);
        pojo.setType(type.getValue());
        commentSubjectDAO.save(pojo);
        return pojo;
    }

    @Override
    public void updateCount(Integer objId, boolean b) throws ObjectNotFoundException {
        CommentSubjectPOJO pojo = commentSubjectDAO.findById(objId).orElse(null);
        if (pojo == null)
            throw new ObjectNotFoundException("Object not found");

        pojo.setCount(pojo.getCount() + 1);
        pojo.setRootCount(pojo.getRootCount() + (b ? 1 : 0));
        commentSubjectDAO.save(pojo);
    }
}
