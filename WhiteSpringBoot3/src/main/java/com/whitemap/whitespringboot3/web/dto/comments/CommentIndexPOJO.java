package com.whitemap.whitespringboot3.pojo.comments;


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

    @Override
    public String toString() {
        return String.format("CommentIndex:[ID=%d, userID=%s, root=%d, parent=%d," +
                " likeCount=%d, state=%d, attrs=%d]",
                ID, userID, root, parent, likeCount, state, attrs);
    }
}
