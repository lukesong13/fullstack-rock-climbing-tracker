package com.clomb.tracker.services;
import com.clomb.tracker.dto.RouteDto;

import java.util.List;

public interface RouteService {

    RouteDto createRoute(RouteDto routeDto);
    RouteDto getRouteById(int id);
    List<RouteDto> getAllRoutes();
    RouteDto updateRoute(int id, RouteDto routeDto);
    String deleteRouteById(int id);
}
