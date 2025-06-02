package com.example.UberProject_AuthService.service;


import com.example.UberProject_AuthService.helpers.AuthPassangerDetails;
import com.example.UberProject_AuthService.models.Passenger;
import com.example.UberProject_AuthService.repositries.PassangerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final PassangerRepository passangerRepository;

    UserDetailServiceImpl(PassangerRepository p){
        passangerRepository=p;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Passenger> passenger= passangerRepository.findPassengerByEmail(username);

        if (passenger.isPresent()){
           return new AuthPassangerDetails(passenger.get());
        }
        else {
            throw new UsernameNotFoundException("Cannot find Passanger with this email");
        }
    }
}
