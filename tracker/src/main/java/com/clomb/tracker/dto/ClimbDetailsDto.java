package com.clomb.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ClimbDetailsDto {

    private int id;
    private int userId;
    private int routeId;
    private int gymId;
    private String notes;
    private Timestamp climbDetailsCreateDate;
    private Timestamp climbDetailsUpdateDate;

}


