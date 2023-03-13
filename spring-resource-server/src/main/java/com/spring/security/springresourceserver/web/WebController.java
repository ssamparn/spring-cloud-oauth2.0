package com.spring.security.springresourceserver.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String home(Authentication authentication) {
        return "Welcome Home! : " + authentication.getName();
    }
}
