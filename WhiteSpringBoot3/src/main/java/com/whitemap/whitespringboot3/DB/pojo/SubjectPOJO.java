package com.whitemap.whitespringboot3.DB.pojo;

import jakarta.persistence.*;

@Table(name = "comment_subject")
@Entity
public class SubjectPOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer id;
    @Column(name = "type")
    private Integer type;
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "count")
    private Integer count;
    @Column(name = "root_count")
    private Integer rootCount;
    @Column(name = "state")
    private Integer state;
}
