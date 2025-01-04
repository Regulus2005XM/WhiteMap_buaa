package com.whitemap.whitespringboot3.web.dto.Site;

public class SiteJwtDTO {
    private String siteName;
    private Double x;
    private Double y;
    private String jwt;

    public SiteJwtDTO(String siteName, Double x, Double y, String jwt) {
        this.siteName = siteName;
        this.x = x;
        this.y = y;
        this.jwt = jwt;
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

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
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
