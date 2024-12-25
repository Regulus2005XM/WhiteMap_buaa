package com.whitemap.whitespringboot3.web.dto.Comment;

public class SendCommentDTO {
    private Integer objId;
    private Integer objType;
    private Integer userID;
    private Integer root;
    private Integer parent;
    private String content;

    public SendCommentDTO(Integer objId, Integer objType, Integer userID, Integer root, Integer parent, String content) {
        this.objId = objId;
        this.objType = objType;
        this.userID = userID;
        this.root = root;
        this.parent = parent;
        this.content = content;
    }

    public Integer getObjId() {
        return objId;
    }

    public Integer getObjType() {
        return objType;
    }

    public Integer getUserID() {
        return userID;
    }

    public Integer getRoot() {
        return root;
    }

    public Integer getParent() {
        return parent;
    }

    public String getContent() {
        return content;
    }
}
