package com.whitemap.whitespringboot3.DB.mapper;

import com.whitemap.whitespringboot3.DB.pojo.comments.CommentIndexPOJO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentIndexPOJO> getRoots(int objId, int objType, List<Integer> attrs, int offset, int limit);

    List<CommentIndexPOJO> getReplies(int root, List<Integer> attrs, int offset, int limit);

    @Options(keyProperty = "ID", useGeneratedKeys = true)
    @Insert("insert into db001.comment_index(obj_id,obj_type,user_id,root,parent) " +
            "values(#{objId},#{objType},#{userId},#{root},#{parent})")
    void insert(CommentIndexPOJO pojo);

    @Select("select * from db001.comment_index where ID = #{id}")
    CommentIndexPOJO getById(Integer id);

    @Select("select * from db001.comment_index where ID = #{id} " +
            "and obj_type = #{objType} and root = #{root} and parent = #{parent}")
    CommentIndexPOJO checkExist(Integer id, Integer objType, Integer root, Integer parent);

    @Select("select * from db001.comment_index where obj_id = #{objId} and obj_type = #{objType}")
    List<CommentIndexPOJO> getBySubject(Integer objId, Integer objType);

    @Delete("delete from db001.comment_index where obj_id = #{objId} and obj_type = #{objType}")
    void deleteSubject(Integer objId, Integer objType);
}
