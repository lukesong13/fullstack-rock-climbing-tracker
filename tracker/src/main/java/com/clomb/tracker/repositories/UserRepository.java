package com.clomb.tracker.repositories;
import com.clomb.tracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
}
