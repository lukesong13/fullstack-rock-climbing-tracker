package com.clomb.tracker.mapper;

import com.clomb.tracker.dto.RouteDto;
import com.clomb.tracker.entities.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    public Route mapToRoute(RouteDto routeDto){
        return new Route(
                routeDto.getId(),
                routeDto.getGrade(),
                routeDto.getSetter(),
                routeDto.getColor(),
                routeDto.getGymId(),
                routeDto.getRouteCreateDate(),
                routeDto.getRouteUpdateDate()
        );

    }

    public RouteDto mapToRouteDto(Route route){
        return new RouteDto(
                route.getId(),
                route.getGrade(),
                route.getSetter(),
                route.getColor(),
                route.getGymId(),
                route.getRouteCreateDate(),
                route.getRouteUpdateDate()
        );


    }
}
