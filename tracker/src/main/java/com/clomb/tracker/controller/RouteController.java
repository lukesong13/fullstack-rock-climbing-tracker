package com.clomb.tracker.controller;

import com.clomb.tracker.dto.RouteDto;
import com.clomb.tracker.services.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.time.Instant;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "http://localhost:3000")
public class RouteController {

    RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    @PostMapping
    public ResponseEntity<RouteDto> addRoute(@RequestBody RouteDto routeDto){
        Instant instant = Instant.now();
        long timestampEpochMilliseconds = instant.toEpochMilli();

        routeDto.setRouteCreateDate(new Timestamp(timestampEpochMilliseconds));
        routeDto.setRouteUpdateDate(new Timestamp(timestampEpochMilliseconds));
        return new ResponseEntity<>(routeService.createRoute(routeDto), HttpStatus.CREATED);
    }

//    /*
//    ResponseEntity extends HttpEntity. HttpEntity is handles requests and responses over HTTP
//    @RequestBody maps the JSON in the request body to the productDto.
//    In the return statement, we are than passing that productDto object to the productService.createProduct()
//    method.
//     */
////
    @GetMapping("/{id}")
    public ResponseEntity<RouteDto> getRouteById(@PathVariable int id) {
        RouteDto routeDto = routeService.getRouteById(id);
                return ResponseEntity.ok(routeDto);
    }

    @GetMapping("/gym/{gymId}")
    public ResponseEntity<List<RouteDto>> getRouteByGymId(@PathVariable int gymId) {
        return ResponseEntity.ok(routeService.getRouteByGymId(gymId));
    }
//
    @GetMapping
    public ResponseEntity<List<RouteDto>> getAllRoutes() {
        List<RouteDto> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(routes);
    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRouteById(@PathVariable int id) {
         String status = routeService.deleteRouteById(id);
        return ResponseEntity.ok(status);
    }
//
    @PutMapping("/{id}")
    public ResponseEntity<RouteDto> updateRoute(@PathVariable int id, @RequestBody Map<String, String> request){
        Instant instant = Instant.now();
        long timestampEpochMilliseconds = instant.toEpochMilli();
        String grade = request.get("grade");
        String setter = request.get("setter");
        String color = request.get("color");
        int gymId = -1;
        Timestamp routeCreateDate = null;
        Timestamp routeUpdateDate = new Timestamp(timestampEpochMilliseconds);

        RouteDto routeDtoFromRequest = new RouteDto(
                id,
                grade,
                setter,
                color,
                gymId,
                routeCreateDate,
               routeUpdateDate);


        RouteDto routeDto = routeService.updateRoute(id,routeDtoFromRequest);

        return ResponseEntity.ok(routeDto);
    }
//
}
