package com.clomb.tracker.repositories;
import com.clomb.tracker.dto.RouteDto;
import com.clomb.tracker.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Integer>{
    @Query(value = "SELECT * FROM routes WHERE gym_id = ?", nativeQuery = true)
    List<Route> getByGymId(int gymId);
}


