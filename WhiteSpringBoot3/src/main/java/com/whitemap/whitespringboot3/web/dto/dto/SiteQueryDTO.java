package com.whitemap.whitespringboot3.pojo.dto;

public class SiteQueryDTO {
    private Double x;
    private Double y;
    private Double range;

    public SiteQueryDTO(Double x, Double y, Double range) {
        this.x = x;
        this.y = y;
        this.range = range;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getRange() {
        return range;
    }
}
