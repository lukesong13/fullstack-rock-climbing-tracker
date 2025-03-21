package com.clomb.tracker.services.impl;

import com.clomb.tracker.dto.ClimbDetailsDto;
import com.clomb.tracker.entities.ClimbDetails;
import com.clomb.tracker.mapper.ClimbDetailsMapper;
import com.clomb.tracker.repositories.ClimbDetailsRepository;
import com.clomb.tracker.services.ClimbDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClimbDetailsServiceImpl implements ClimbDetailsService {

    @Autowired
    private ClimbDetailsRepository climbDetailsRepository;

    @Autowired
    private ClimbDetailsMapper climbDetailsMapper;


    @Override
    public ClimbDetailsDto createClimbDetails(ClimbDetailsDto climbDetailsDto) {
        ClimbDetails climbDetails = climbDetailsMapper.mapToClimbDetails(climbDetailsDto);
        ClimbDetails savedClimbDetails = climbDetailsRepository.save(climbDetails);

        return climbDetailsMapper.mapToClimbDetailsDto(savedClimbDetails);
    }

    @Override
    public ClimbDetailsDto getClimbDetailsById(int id) {
        ClimbDetails climbDetails = climbDetailsRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Climb detail of this ID does not exist"));
        return climbDetailsMapper.mapToClimbDetailsDto(climbDetails);
    }

    @Override
    public List<ClimbDetailsDto> getAllClimbDetails() {
        List<ClimbDetails> climbDetails = climbDetailsRepository.findAll();
             List<ClimbDetailsDto> climbDetailsDtos = climbDetails.stream().map(climbDetailsMapper::mapToClimbDetailsDto).collect(Collectors.toList());
             return climbDetailsDtos;
    }

    @Override
    public ClimbDetailsDto updateClimbDetails(int id, ClimbDetailsDto climbdetailsDto) {
        ClimbDetails climbDetails = climbDetailsRepository.findById(id).
                orElseThrow( () -> new RuntimeException("Climb detail of this ID does not exist"));
            climbDetails.setRouteId(climbdetailsDto.getRouteId());
            climbDetails.setGymId(climbdetailsDto.getGymId());
            climbDetails.setNotes(climbdetailsDto.getNotes());
            climbDetails.setClimbDetailsUpdateDate(climbdetailsDto.getClimbDetailsUpdateDate());

        ClimbDetails savedClimbDetails = climbDetailsRepository.save(climbDetails);
        return climbDetailsMapper.mapToClimbDetailsDto(savedClimbDetails);
    }

    @Override
    public String deleteClimbDetailsById(int id) {
        if(climbDetailsRepository.existsById(id)){
            climbDetailsRepository.deleteById((id));
            return "Successfully deleted climb detail with id "+ id;
        } else{
            return "no record of climb detail with id "+ id;
        }
    }

}
