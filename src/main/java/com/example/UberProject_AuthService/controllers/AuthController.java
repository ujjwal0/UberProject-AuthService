package com.example.UberProject_AuthService.controllers;


import com.example.UberProject_AuthService.dto.PassangerDTO;
import com.example.UberProject_AuthService.dto.PassangerSignupRequestDTO;
import com.example.UberProject_AuthService.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private AuthService authService;
    public AuthController(AuthService authService){
        this.authService=authService;
    }
    @PostMapping("/signup/passanger")
    public ResponseEntity<PassangerDTO> signUp(@RequestBody PassangerSignupRequestDTO passangerSignupRequestDTO){
        PassangerDTO response=authService.signupPassanger(passangerSignupRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/signin/passanger")
    public ResponseEntity<?> signIn(){
        return new ResponseEntity<>(10,HttpStatus.CREATED);
    }
}
