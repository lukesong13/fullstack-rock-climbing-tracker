package com.clomb.tracker.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="routes")
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "grade")
    private String grade;

    @Column(name = "setter")
    private String setter;

    @Column(name = "color")
    private String color;

    @Column(name = "gym_id")
    private int gymId;

    @Column(name = "route_create_date")
    private Timestamp routeCreateDate;

    @Column(name = "route_update_date")
    private Timestamp routeUpdateDate;

}


