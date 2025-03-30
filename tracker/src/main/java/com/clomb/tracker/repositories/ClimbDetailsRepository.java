package com.clomb.tracker.repositories;
import com.clomb.tracker.entities.ClimbDetails;
import com.clomb.tracker.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClimbDetailsRepository extends JpaRepository<ClimbDetails,Integer>{
    @Query(value = "SELECT * FROM climb_details WHERE user_id = ?", nativeQuery = true)
    List<ClimbDetails> getByUserId(int userId);
}