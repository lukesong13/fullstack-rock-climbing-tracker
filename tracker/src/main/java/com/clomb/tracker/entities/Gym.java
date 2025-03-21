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
@Table(name="gyms")
@Entity
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "gym_name")
    private String gymName;

    @Column(name = "gym_address")
    private String gymAddress;

    @Column(name = "gym_create_date")
    private Timestamp gymCreateDate;

    @Column(name = "gym_update_date")
    private Timestamp gymUpdateDate;

}
