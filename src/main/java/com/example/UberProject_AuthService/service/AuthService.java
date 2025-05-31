package com.example.UberProject_AuthService.service;


import com.example.UberProject_AuthService.dto.PassangerDTO;
import com.example.UberProject_AuthService.dto.PassangerSignupRequestDTO;
import com.example.UberProject_AuthService.models.Passenger;
import com.example.UberProject_AuthService.repositries.PassangerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PassangerRepository passangerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(PassangerRepository passangerRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.passangerRepository=passangerRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }
    public PassangerDTO signupPassanger(PassangerSignupRequestDTO passangerSignupRequestDTO) {
        Passenger passenger = Passenger.builder()
                .email(passangerSignupRequestDTO.getEmail())
                .name(passangerSignupRequestDTO.getName())
                .password(bCryptPasswordEncoder.encode(passangerSignupRequestDTO.getPassword()))
                .phoneNumber(passangerSignupRequestDTO.getPhoneNumber())
                .build();

        Passenger newPassanger=passangerRepository.save(passenger);

       return PassangerDTO.from(newPassanger);


    }
}
