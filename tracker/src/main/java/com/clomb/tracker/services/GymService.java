package com.clomb.tracker.services;
import com.clomb.tracker.dto.GymDto;
import com.clomb.tracker.dto.UserDto;

import java.util.List;

public interface GymService {

    GymDto createGym(GymDto gymDto);
    GymDto getGymById(int id);
    List<GymDto> getAllGyms();
    GymDto updateGym(int id, GymDto gymDto);
    String deleteGymById(int id);
}
