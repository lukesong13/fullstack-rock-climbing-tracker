package com.clomb.tracker.repositories;
import com.clomb.tracker.entities.ClimbDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimbDetailsRepository extends JpaRepository<ClimbDetails,Integer>{
}