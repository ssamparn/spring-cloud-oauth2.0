package com.microservices.resourceserver.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("security")
public class SecurityProperties {

    private JwtProperties jwt;

    @Getter
    @Setter
    public static class JwtProperties {
        private Resource publicKey;
    }
}
