package com.clomb.tracker.mapper;

import com.clomb.tracker.dto.ClimbDetailsDto;
import com.clomb.tracker.entities.ClimbDetails;
import org.springframework.stereotype.Component;

@Component
public class ClimbDetailsMapper {

    public ClimbDetails mapToClimbDetails(ClimbDetailsDto ClimbDetailsDto){
        return new ClimbDetails(
                ClimbDetailsDto.getId(),
                ClimbDetailsDto.getUserId(),
                ClimbDetailsDto.getRouteId(),
                ClimbDetailsDto.getGymId(),
                ClimbDetailsDto.getNotes(),
                ClimbDetailsDto.getClimbDetailsCreateDate(),
                ClimbDetailsDto.getClimbDetailsUpdateDate()
        );
    }

    public ClimbDetailsDto mapToClimbDetailsDto(ClimbDetails climbDetails){
        return new ClimbDetailsDto(
                climbDetails.getId(),
                climbDetails.getUserId(),
                climbDetails.getRouteId(),
                climbDetails.getGymId(),
                climbDetails.getNotes(),
                climbDetails.getClimbDetailsCreateDate(),
                climbDetails.getClimbDetailsUpdateDate()
        );
    }
}
