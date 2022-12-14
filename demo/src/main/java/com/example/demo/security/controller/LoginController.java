package com.example.demo.security.controller;

import com.example.demo.domain.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private AuthService serviceA;

    public LoginController(AuthService serviceA) {
        this.serviceA = serviceA;
    }

    @GetMapping("/auth/principal")
    public ResponseEntity<?> getAuthData()
    {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
        {
            var user = serviceA.GetAuthentificatedUserData();
            return ResponseEntity.ok(user);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }







}
