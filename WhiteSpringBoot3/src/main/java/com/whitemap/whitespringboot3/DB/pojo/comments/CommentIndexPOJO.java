package com.whitemap.whitespringboot3.DB.pojo.comments;


public class CommentIndexPOJO {
    private Integer ID;
    private Integer objId;
    private Integer objType;
    private Integer userID;
    private Integer root;
    private Integer parent;
    private Integer likeCount;
    private Integer state;
    private Integer attrs;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Integer getObjType() {
        return objType;
    }

    public void setObjType(Integer objType) {
        this.objType = objType;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAttrs() {
        return attrs;
    }

    public void setAttrs(Integer attrs) {
        this.attrs = attrs;
    }

    @Override
    public String toString() {
        return String.format("CommentIndex:[ID=%d, userID=%s, root=%d, parent=%d," +
                " likeCount=%d, state=%d, attrs=%d]",
                ID, userID, root, parent, likeCount, state, attrs);
    }
}
