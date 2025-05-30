package com.example.UberProject_AuthService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel {
    @Column(nullable = false)
    private String name;

    @Column(name = "email",nullable = false) // Ensure this matches the DB column name
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();
}
