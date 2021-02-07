package com.microservices.resourceserver.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> getAccessToken() {

        String accessToken = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getDetails();
        if (details instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) details;
            accessToken = oAuth2AuthenticationDetails.getTokenValue();
        }
        return ResponseEntity.ok(Collections.singletonMap("principal", accessToken));
    }
}
