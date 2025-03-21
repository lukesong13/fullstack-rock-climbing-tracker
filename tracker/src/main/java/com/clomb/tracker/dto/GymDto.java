package com.clomb.tracker.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class GymDto {

    private int id;
    private String gymName;
    private String gymAddress;
    private Timestamp gymCreateDate;
    private Timestamp gymUpdateDate;

}


