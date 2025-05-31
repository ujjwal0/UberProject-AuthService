package com.example.UberProject_AuthService.dto;

import com.example.UberProject_AuthService.models.Passenger;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassangerDTO {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String createdAt;

    public static PassangerDTO from(Passenger p){
        PassangerDTO result=PassangerDTO.builder()
                .id(p.getId().toString())
                .createdAt(p.getCreatedAt().toString())
                .email(p.getEmail())
                .password(p.getPassword())
                .phoneNumber(p.getPhoneNumber())
                .name(p.getName())
                .build();

        return result;
    }

}
