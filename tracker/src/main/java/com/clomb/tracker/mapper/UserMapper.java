package com.clomb.tracker.mapper;

import com.clomb.tracker.dto.UserDto;
import com.clomb.tracker.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserDto UserDto){
        return new User(
                UserDto.getId(),
                UserDto.getFirstName(),
                UserDto.getLastName(),
                UserDto.getEmail(),
                UserDto.getShoes(),
                UserDto.getChalk(),
                UserDto.getUsername(),
                UserDto.getPassword(),
                UserDto.getGender(),
                UserDto.getUserCreateDate(),
                UserDto.getUserUpdateDate()
        );

    }

    public UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getShoes(),
                user.getChalk(),
                user.getUsername(),
                user.getPassword(),
                user.getGender(),
                user.getCreateDate(),
                user.getUpdateDate()
        );


    }
}
