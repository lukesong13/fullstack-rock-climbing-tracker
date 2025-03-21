package com.clomb.tracker.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String shoes;
    private String chalk;
    private String username;
    private String password;
    private String gender;
    private Timestamp createDate;
    private Timestamp updateDate;

}

