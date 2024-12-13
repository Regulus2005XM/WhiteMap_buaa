package com.whitemap.whitespringboot3.pojo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class SiteDTO {
    private String siteName;
    private Double x;
    private Double y;

    public SiteDTO(String siteName, Double x, Double y) {
        this.siteName = siteName;
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return "SiteDTO{" +
                "siteName='" + siteName + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
