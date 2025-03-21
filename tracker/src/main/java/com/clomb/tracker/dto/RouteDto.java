package com.clomb.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class RouteDto {

    private int id;
    private String grade;
    private String setter;
    private String color;
    private int gymId;
    private Timestamp routeCreateDate;
    private Timestamp routeUpdateDate;

}


