package com.whitemap.whitespringboot3.web.dto.Comment;

import com.whitemap.whitespringboot3.entity.Comment;

import java.sql.Timestamp;
import java.util.List;

public class SubjectDTO {
    private Integer Id;
    private Integer type;
    private Integer ownerId;
    private Integer count;
    private Integer rootCount;
    private Timestamp createTime;
    private List<Comment> comments;

    public SubjectDTO(Integer id, Integer type, Integer ownerId, Integer count, Integer rootCount, Timestamp createTime, List<Comment> comments) {
        Id = id;
        this.type = type;
        this.ownerId = ownerId;
        this.count = count;
        this.rootCount = rootCount;
        this.createTime = createTime;
        this.comments = comments;
    }

    public Integer getId() {
        return Id;
    }

    public Integer getType() {
        return type;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getRootCount() {
        return rootCount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
