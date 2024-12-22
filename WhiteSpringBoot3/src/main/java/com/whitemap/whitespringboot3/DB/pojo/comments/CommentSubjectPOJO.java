package com.whitemap.whitespringboot3.DB.pojo.comments;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Table(name = "comment_subject")
@Entity
public class CommentSubjectPOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "type")
    private Integer type;
    @Column(name ="owner_id")
    private Integer ownerId;
    @Column(name = "count")
    private Integer count;
    @Column(name = "root_count")
    private Integer rootCount;
    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRootCount() {
        return rootCount;
    }

    public void setRootCount(Integer rootCount) {
        this.rootCount = rootCount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
