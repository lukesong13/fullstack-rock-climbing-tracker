package com.clomb.tracker.services.impl;

import com.clomb.tracker.dto.GymDto;
import com.clomb.tracker.dto.RouteDto;
import com.clomb.tracker.entities.Gym;
import com.clomb.tracker.entities.Route;
import com.clomb.tracker.mapper.RouteMapper;
import com.clomb.tracker.repositories.RouteRepository;
import com.clomb.tracker.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteMapper routeMapper;


    @Override
    public RouteDto createRoute(RouteDto routeDto) {
        Route route = routeMapper.mapToRoute(routeDto);
        Route savedRoute = routeRepository.save(route);

        return routeMapper.mapToRouteDto(savedRoute);
    }

    @Override
    public RouteDto getRouteById(int id) {
        Route route = routeRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Route of this ID does not exist"));
        return routeMapper.mapToRouteDto(route);
    }

    @Override
    public List<RouteDto> getAllRoutes() {
        List<Route> routes = routeRepository.findAll();
        List<RouteDto> routeDtos = routes.stream().map(routeMapper::mapToRouteDto).collect(Collectors.toList());
        return routeDtos;
    }


    @Override
    public RouteDto updateRoute(int id, RouteDto routeDto) {
        Route route = routeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Route of this ID does not exist"));

        route.setGrade(routeDto.getGrade());
        route.setColor(routeDto.getColor());
        route.setSetter(routeDto.getSetter());
        route.setRouteUpdateDate(routeDto.getRouteUpdateDate());

        Route savedRoute = routeRepository.save(route);
        return routeMapper.mapToRouteDto(savedRoute);
    }

    @Override
    public String deleteRouteById(int id) {
        if (routeRepository.existsById(id)) {
            routeRepository.deleteById((id));
            return "Successfully deleted route with id " + id;
        } else {
            return "no record of route with id " + id;
        }
    }
}

