package com.clomb.tracker.mapper;

import com.clomb.tracker.dto.GymDto;
import com.clomb.tracker.entities.Gym;
import org.springframework.stereotype.Component;

@Component
public class GymMapper {

    public Gym mapToGym(GymDto GymDto){
        return new Gym(
                GymDto.getId(),
                GymDto.getGymName(),
                GymDto.getGymAddress(),
                GymDto.getGymCreateDate(),
                GymDto.getGymUpdateDate()
        );

    }

    public GymDto mapToGymDto(Gym gym){
        return new GymDto(
                gym.getId(),
                gym.getGymName(),
                gym.getGymAddress(),
                gym.getGymCreateDate(),
                gym.getGymUpdateDate()
        );


    }
}
