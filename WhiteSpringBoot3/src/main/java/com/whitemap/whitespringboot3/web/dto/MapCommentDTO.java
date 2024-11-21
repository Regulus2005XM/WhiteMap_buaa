package com.whitemap.whitespringboot3.web.dto;

public class MapCommentDTO {
    private String createUserName;
    private String commentText;
    private int likes;
    private String fatherComponent;
    private String sonComponent;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getFatherComponent() {
        return fatherComponent;
    }

    public void setFatherComponent(String fatherComponent) {
        this.fatherComponent = fatherComponent;
    }

    public String getSonComponent() {
        return sonComponent;
    }

    public void setSonComponent(String sonComponent) {
        this.sonComponent = sonComponent;
    }

    @Override
    public String toString() {
        return "MapCommentDTO{" +
                "createUserName='" + createUserName + '\'' +
                ", commentText='" + commentText + '\'' +
                ", likes=" + likes +
                ", fatherComponent='" + fatherComponent + '\'' +
                ", sonComponent='" + sonComponent + '\'' +
                '}';
    }
}
