package com.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeResource {
	@GetMapping("/home")
    public String homeInit() {
        System.out.println("home controller");
        return "Welcome to HOME page of your application";
    }
}
