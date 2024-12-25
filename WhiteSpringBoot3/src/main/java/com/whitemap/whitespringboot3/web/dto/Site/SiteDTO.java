package com.whitemap.whitespringboot3.web.dto.Site;

public class SiteDTO {
    private String siteName;
    private Double x;
    private Double y;
    private Integer userId;

    public SiteDTO(String siteName, Double x, Double y, Integer userId) {
        this.siteName = siteName;
        this.x = x;
        this.y = y;
        this.userId = userId;
    }

    public String getSiteName() {
        return siteName;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SiteDTO{" +
                "siteName='" + siteName + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
