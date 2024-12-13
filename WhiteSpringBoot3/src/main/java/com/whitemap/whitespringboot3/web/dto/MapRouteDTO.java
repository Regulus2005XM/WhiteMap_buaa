package com.whitemap.whitespringboot3.web.dto;

import java.util.Objects;

public class MapRouteDTO {
    private String onMapStartLng;
    private String onMapStartLat;
    private String onMapEndLng;
    private String onMapEndLat;
    private String routeLength;
    private boolean isOneWay;

    public String getOnMapStartLng() {
        return onMapStartLng;
    }

    public void setOnMapStartLng(String onMapStartLng) {
        this.onMapStartLng = onMapStartLng;
    }

    public String getOnMapStartLat() {
        return onMapStartLat;
    }

    public void setOnMapStartLat(String onMapStartLat) {
        this.onMapStartLat = onMapStartLat;
    }

    public String getOnMapEndLng() {
        return onMapEndLng;
    }

    public void setOnMapEndLng(String onMapEndLng) {
        this.onMapEndLng = onMapEndLng;
    }

    public String getOnMapEndLat() {
        return onMapEndLat;
    }

    public void setOnMapEndLat(String onMapEndLat) {
        this.onMapEndLat = onMapEndLat;
    }

    public String getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(String routeLength) {
        this.routeLength = routeLength;
    }

    public boolean isOneWay() {
        return isOneWay;
    }

    public void setOneWay(boolean oneWay) {
        isOneWay = oneWay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapRouteDTO that = (MapRouteDTO) o;
        return isOneWay == that.isOneWay && Objects.equals(onMapStartLng, that.onMapStartLng) && Objects.equals(onMapStartLat, that.onMapStartLat) && Objects.equals(onMapEndLng, that.onMapEndLng) && Objects.equals(onMapEndLat, that.onMapEndLat) && Objects.equals(routeLength, that.routeLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(onMapStartLng, onMapStartLat, onMapEndLng, onMapEndLat, routeLength, isOneWay);
    }

    @Override
    public String toString() {
        return "MapRouteDTO{" +
                "onMapStartLng='" + onMapStartLng + '\'' +
                ", onMapStartLat='" + onMapStartLat + '\'' +
                ", onMapEndLng='" + onMapEndLng + '\'' +
                ", onMapEndLat='" + onMapEndLat + '\'' +
                ", routeLength='" + routeLength + '\'' +
                ", isOneWay=" + isOneWay +
                '}';
    }
}
