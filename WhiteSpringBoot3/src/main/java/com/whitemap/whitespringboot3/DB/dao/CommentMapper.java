package com.whitemap.whitespringboot3.DB.dao;

import com.whitemap.whitespringboot3.pojo.comments.CommentIndexPOJO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentIndexPOJO> getRoots(int objId, int objType, List<Integer> attrs, int offset, int limit);

    List<CommentIndexPOJO> getReplies(int objId, int objType, int root, List<Integer> attrs, int offset, int limit);

    List<CommentIndexPOJO> getRepliesByTime(int objId, int objType, int root, List<Integer> attrs, int offset, int limit);
}
