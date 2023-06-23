package com.spring.security.springresourceserver.web;

import com.spring.security.springresourceserver.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class WebController {

    @GetMapping("/principal")
    public ResponseEntity<String> home(Authentication authentication) {
        return new ResponseEntity<>("Welcome Home! : " + authentication.getName(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = getProductList();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    private List<Product> getProductList() {
        return Arrays.asList(new Product(1, "I Pad", 10),
                new Product(2, "I Phone", 12),
                new Product(3, "MacBook", 15));
    }
}
