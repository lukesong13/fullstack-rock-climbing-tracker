package com.clomb.tracker.repositories;
import com.clomb.tracker.entities.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym,Integer>{
}