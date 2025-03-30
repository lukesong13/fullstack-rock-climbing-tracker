package com.clomb.tracker.controller;

import com.clomb.tracker.dto.ClimbDetailsDto;
import com.clomb.tracker.dto.RouteDto;
import com.clomb.tracker.services.ClimbDetailsService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/climbDetails")
@CrossOrigin(origins = "http://localhost:3000")
public class ClimbDetailsController {

    ClimbDetailsService climbDetailsService;

    public ClimbDetailsController(ClimbDetailsService climbDetailsService) {
        this.climbDetailsService = climbDetailsService;
    }
    @PostMapping
    public ResponseEntity<ClimbDetailsDto> addUser(@RequestBody ClimbDetailsDto climbDetailsDto){
        Instant instant = Instant.now();
        long timestampEpochMilliseconds = instant.toEpochMilli();

        climbDetailsDto.setClimbDetailsCreateDate(new Timestamp(timestampEpochMilliseconds));
        climbDetailsDto.setClimbDetailsUpdateDate(new Timestamp(timestampEpochMilliseconds));
        return new ResponseEntity<>(climbDetailsService.createClimbDetails(climbDetailsDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
       public ResponseEntity<ClimbDetailsDto> getClimbDetailsById(@PathVariable int id) {
            ClimbDetailsDto climbDetailsDto = climbDetailsService.getClimbDetailsById(id);
                return ResponseEntity.ok(climbDetailsDto);
    }

    @GetMapping
    public ResponseEntity<List<ClimbDetailsDto>> getAllClimbDetails(){
        List<ClimbDetailsDto> climbDetails = climbDetailsService.getAllClimbDetails();
        return ResponseEntity.ok(climbDetails);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ClimbDetailsDto>> getClimbDetailsByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(climbDetailsService.getClimbDetailsByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClimbDetailById(@PathVariable int id){
        String status = climbDetailsService.deleteClimbDetailsById((id));
        return ResponseEntity.ok(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClimbDetailsDto> updateClimbDetails(@PathVariable int id, @RequestBody Map<String, String> request){
        Instant instant = Instant.now();
        long timestampEpochMilliseconds = instant.toEpochMilli();
        int userId = -1;
        int routeId = Integer.parseInt(request.get("routeId"));
        int gymId = Integer.parseInt(request.get("gymId"));
        String notes = request.get("notes");
        Timestamp climbDetailsCreateDate = null;
        Timestamp climbDetailsUpdateDate = new Timestamp(timestampEpochMilliseconds);

        ClimbDetailsDto climbDetailsDtoFromRequest = new ClimbDetailsDto(
                id,
                userId,
                routeId,
                gymId,
                notes,
                climbDetailsCreateDate,
                climbDetailsUpdateDate);

        ClimbDetailsDto climbDetailsDto = climbDetailsService.updateClimbDetails(id,climbDetailsDtoFromRequest);
        return ResponseEntity.ok(climbDetailsDto);
    }


}
