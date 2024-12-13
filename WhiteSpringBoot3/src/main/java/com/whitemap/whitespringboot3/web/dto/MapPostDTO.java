package com.whitemap.whitespringboot3.web.dto;

import java.util.Arrays;

public class MapPostDTO {
    private String createUserName;
    private String title;
    private String description;
    private int starPoint;

    private int likes;

    private String[] tags;

    private String url;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStarPoint() {
        return starPoint;
    }

    public void setStarPoint(int starPoint) {
        this.starPoint = starPoint;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MapPostDTO{" +
                "createUserName='" + createUserName + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", starPoint=" + starPoint +
                ", likes=" + likes +
                ", tags=" + Arrays.toString(tags) +
                ", url='" + url + '\'' +
                '}';
    }
}
