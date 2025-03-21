package com.clomb.tracker.services;
import com.clomb.tracker.dto.ClimbDetailsDto;

import java.util.List;

public interface ClimbDetailsService {

    ClimbDetailsDto createClimbDetails(ClimbDetailsDto climbdetailsDto);
    ClimbDetailsDto getClimbDetailsById(int id);
    List<ClimbDetailsDto> getAllClimbDetails();
    ClimbDetailsDto updateClimbDetails(int id, ClimbDetailsDto climbdetailsDto);
    String deleteClimbDetailsById(int id);
}
