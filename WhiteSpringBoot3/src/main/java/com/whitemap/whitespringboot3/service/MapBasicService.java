package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.web.dto.MapPointDTO;
import com.whitemap.whitespringboot3.web.dto.MapRouteDTO;

public class MapBasicService {
    public boolean isConnected(MapPointDTO pointA, MapPointDTO pointB) {

        MapRouteDTO[] routeAStart = pointA.getStartRoutes();

        return false;
    }
    public MapRouteDTO[] minRoute(MapPointDTO pointA, MapPointDTO pointB) {

    }
}
