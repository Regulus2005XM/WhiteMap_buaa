package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.Common.SubjectType;
import com.whitemap.whitespringboot3.DB.dao.CommentContentDAO;
import com.whitemap.whitespringboot3.DB.dao.CommentMapper;
import com.whitemap.whitespringboot3.DB.pojo.comments.CommentContentPOJO;
import com.whitemap.whitespringboot3.DB.pojo.comments.CommentIndexPOJO;
import com.whitemap.whitespringboot3.entities.Comment;
import com.whitemap.whitespringboot3.web.dto.Comment.SendCommentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentContentDAO commentContentDAO;

    @Override
    public boolean commentExist(Integer objId, Integer objType, Integer root, Integer parent) {
        CommentIndexPOJO pojo = commentMapper.checkExist(objId,objType,root,parent);
        return pojo != null;
    }

    @Override
    public Comment add(SendCommentDTO dto) {
        //Index
        CommentIndexPOJO idx = new CommentIndexPOJO();
        BeanUtils.copyProperties(dto, idx);
        commentMapper.insert(idx);
        //Content
        CommentContentPOJO content = new CommentContentPOJO();
        content.setId(idx.getID());
        content.setContent(dto.getContent());
        Integer parentUserId = -1;
        if(dto.getParent() > 0)
            parentUserId = commentOwner(dto.getParent());
        content.setParentUserId(parentUserId);
        commentContentDAO.save(content);
        //构建返回值
        Comment res = new Comment();
        BeanUtils.copyProperties(idx, res);
        BeanUtils.copyProperties(content, res);
        return res;
    }

    @Override
    public void deleteSubject(Integer subjectId, SubjectType type) {
        List<CommentIndexPOJO> list = commentMapper.getBySubject(subjectId,type.getValue());
        // 并发删除
        for (var pojo : list) {
            CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
               commentContentDAO.deleteById(list.get(pojo.getID()).getID());
               return null;
            });
        }
        commentMapper.deleteSubject(subjectId,type.getValue());
    }

    private Integer commentOwner(Integer contentId){
        CommentContentPOJO pojo = commentContentDAO.findById(contentId).orElseThrow();
        return pojo.getParentUserId();
    }
}
