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
@Table(name="climb_details")
@Entity
public class ClimbDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "route_id")
    private int routeId;

    @Column(name = "gym_id")
    private int gymId;

    @Column(name = "notes")
    private String notes;

    @Column(name = "climb_details_create_date")
    private Timestamp climbDetailsCreateDate;

    @Column(name = "climb_details_update_date")
    private Timestamp climbDetailsUpdateDate;

}
