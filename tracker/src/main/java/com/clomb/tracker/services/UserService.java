package com.clomb.tracker.services;

import com.clomb.tracker.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto UserDto);
    UserDto getUserById(int id);
    List<UserDto> getAllUsers();
    UserDto updateUser(int id, UserDto userDto);
    String deleteUserById(int id);


    /*
    create new user
    get user
    update user
    delete user



     */


}
