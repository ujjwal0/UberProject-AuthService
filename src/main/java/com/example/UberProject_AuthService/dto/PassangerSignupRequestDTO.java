package com.example.UberProject_AuthService.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassangerSignupRequestDTO {
    private String email;
    private String password;
    private String phoneNumber;
    private String name;

}
