package com.microservices.resourceserver.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/status/check")
    public String status() {
        return "Working";
    }

    @GetMapping("/get-principal")
    public ResponseEntity<Principal> get(final Principal principal) {
        return new ResponseEntity<>(principal, HttpStatus.OK);
    }

    @GetMapping("/access-token")
    public ResponseEntity<Jwt> getAccessToken(@AuthenticationPrincipal Jwt jwt) {
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
}
