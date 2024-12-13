package com.whitemap.whitespringboot3.web.dto;

import java.util.Objects;

public class MapPointDTO {
    private String followPost;
    private String onMapLng;
    private String onMapLat;
    private String pointName;
    private String averageStar;
    private String sumLikes;

    public String getFollowPost() {
        return followPost;
    }

    public void setFollowPost(String followPost) {
        this.followPost = followPost;
    }

    public String getOnMapLng() {
        return onMapLng;
    }

    public void setOnMapLng(String onMapLng) {
        this.onMapLng = onMapLng;
    }

    public String getOnMapLat() {
        return onMapLat;
    }

    public void setOnMapLat(String onMapLat) {
        this.onMapLat = onMapLat;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getAverageStar() {
        return averageStar;
    }

    public void setAverageStar(String averageStar) {
        this.averageStar = averageStar;
    }

    public String getSumLikes() {
        return sumLikes;
    }

    public void setSumLikes(String sumLikes) {
        this.sumLikes = sumLikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapPointDTO that = (MapPointDTO) o;
        return Objects.equals(followPost, that.followPost) && Objects.equals(onMapLng, that.onMapLng) && Objects.equals(onMapLat, that.onMapLat) && Objects.equals(pointName, that.pointName) && Objects.equals(averageStar, that.averageStar) && Objects.equals(sumLikes, that.sumLikes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followPost, onMapLng, onMapLat, pointName, averageStar, sumLikes);
    }

    @Override
    public String toString() {
        return "MapPointDTO{" +
                "followPost='" + followPost + '\'' +
                ", onMapLng='" + onMapLng + '\'' +
                ", onMapLat='" + onMapLat + '\'' +
                ", pointName='" + pointName + '\'' +
                ", averageStar='" + averageStar + '\'' +
                ", sumLikes='" + sumLikes + '\'' +
                '}';
    }

    public MapRouteDTO[] getStartRoutes() {
        return null;
    }
}
