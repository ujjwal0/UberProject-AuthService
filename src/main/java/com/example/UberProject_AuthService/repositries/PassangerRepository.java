package com.example.UberProject_AuthService.repositries;

import com.example.UberProject_AuthService.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassangerRepository extends JpaRepository<Passenger,Long> {

}
