package com.clomb.tracker.controller;

import com.clomb.tracker.dto.UserDto;
import com.clomb.tracker.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        Instant instant = Instant.now();
        long timestampEpochMilliseconds = instant.toEpochMilli();

        userDto.setCreateDate(new Timestamp(timestampEpochMilliseconds));
        userDto.setUpdateDate(new Timestamp(timestampEpochMilliseconds));
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }
    /*
    ResponseEntity extends HttpEntity. HttpEntity is handles requests and responses over HTTP
    @RequestBody maps the JSON in the request body to the productDto.
    In the return statement, we are than passing that productDto object to the productService.createProduct()
    method.
     */

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        UserDto userDto = userService.getUserById(id);
                return ResponseEntity.ok(userDto);

    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        String status = userService.deleteUserById(id);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody Map<String, String> request){
        Instant instant = Instant.now();
        long timestampEpochMilliseconds = instant.toEpochMilli();

        String firstName = request.get("firstName");
        String lastName = request.get("lastName");
        String email = request.get("email");
        String shoes = request.get("shoes");
        String chalk = request.get("chalk");
        String username = request.get("username");
        String password = request.get("password");
        String gender = request.get("gender");
        Timestamp createDate = null;
        Timestamp updateDate = new Timestamp(timestampEpochMilliseconds);

        UserDto userDtoFromRequest = new UserDto(
                id,
                firstName,
                lastName,
                email,
                shoes,
                chalk,
                username,
                password,
                gender,
                createDate,
                updateDate);

        UserDto userDto = userService.updateUser(id,userDtoFromRequest);

        return ResponseEntity.ok(userDto);
    }

}
