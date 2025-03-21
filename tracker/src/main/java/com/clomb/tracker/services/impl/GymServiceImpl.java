package com.clomb.tracker.services.impl;

import com.clomb.tracker.dto.GymDto;
import com.clomb.tracker.dto.UserDto;
import com.clomb.tracker.entities.Gym;
import com.clomb.tracker.entities.User;
import com.clomb.tracker.mapper.GymMapper;
import com.clomb.tracker.repositories.GymRepository;
import com.clomb.tracker.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymServiceImpl implements GymService {

    @Autowired
    private GymRepository gymRepository;

    @Autowired
    private GymMapper gymMapper;


    @Override
    public GymDto createGym(GymDto gymDto) {
        Gym gym = gymMapper.mapToGym(gymDto);
        Gym savedGym = gymRepository.save(gym);

        return gymMapper.mapToGymDto(savedGym);
    }

    @Override
    public GymDto getGymById(int id) {
        Gym gym = gymRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Gym of this ID does not exist"));
        return gymMapper.mapToGymDto(gym);
    }

    @Override
    public List<GymDto> getAllGyms() {
        List<Gym> gyms = gymRepository.findAll();
        List<GymDto> gymDtos = gyms.stream().map(gymMapper::mapToGymDto).collect(Collectors.toList());
        return gymDtos;
    }

    @Override
    public GymDto updateGym(int id, GymDto gymDto) {
        Gym gym = gymRepository.findById(id).
                orElseThrow( () -> new RuntimeException("User of this ID does not exist"));

        gym.setGymName(gymDto.getGymName());
        gym.setGymAddress(gymDto.getGymAddress());
        gym.setGymUpdateDate(gymDto.getGymUpdateDate());

        Gym savedGym = gymRepository.save(gym);
        return gymMapper.mapToGymDto(savedGym);
    }

    @Override
    public String deleteGymById(int id) {
        if(gymRepository.existsById(id)){
            gymRepository.deleteById((id));
            return "Successfully deleted gym with id "+ id;
        } else{
            return "no record of gym with id "+ id;
        }
    }




}
