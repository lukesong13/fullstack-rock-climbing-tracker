package com.clomb.tracker.controller;

import com.clomb.tracker.dto.GymDto;
import com.clomb.tracker.services.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.time.Instant;

@RestController
@RequestMapping("/api/gyms")
@CrossOrigin(origins = "http://localhost:3000")
public class GymController {

    GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }
    @PostMapping
    public ResponseEntity<GymDto> addUser(@RequestBody GymDto gymDto){
        Instant instant = Instant.now();
        long timestampEpochMilliseconds = instant.toEpochMilli();

        gymDto.setGymCreateDate(new Timestamp(timestampEpochMilliseconds));
        gymDto.setGymUpdateDate(new Timestamp(timestampEpochMilliseconds));
        return new ResponseEntity<>(gymService.createGym(gymDto), HttpStatus.CREATED);
    }

    /*
    ResponseEntity extends HttpEntity. HttpEntity is handles requests and responses over HTTP
    @RequestBody maps the JSON in the request body to the productDto.
    In the return statement, we are than passing that productDto object to the productService.createProduct()
    method.
     */
//
    @GetMapping("/{id}")
    public ResponseEntity<GymDto> getGymById(@PathVariable int id) {
        GymDto gymDto = gymService.getGymById(id);
                return ResponseEntity.ok(gymDto);

    }

    @GetMapping
    public ResponseEntity<List<GymDto>> getAllUsers() {
        List<GymDto> gyms = gymService.getAllGyms();
        return ResponseEntity.ok(gyms);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGymById(@PathVariable int id) {
         String status = gymService.deleteGymById(id);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymDto> updateGym(@PathVariable int id, @RequestBody Map<String, String> request){
        Instant instant = Instant.now();
        long timestampEpochMilliseconds = instant.toEpochMilli();
        String gymName = request.get("gymName");
        String gymAddress = request.get("gymAddress");
        Timestamp gymCreateDate = null;
        Timestamp gymUpdateDate = new Timestamp(timestampEpochMilliseconds);

        GymDto gymDtoFromRequest = new GymDto(
                id,
                gymName,
                gymAddress,
               gymCreateDate,
               gymUpdateDate);

        GymDto gymDto = gymService.updateGym(id,gymDtoFromRequest);

        return ResponseEntity.ok(gymDto);
    }

}
