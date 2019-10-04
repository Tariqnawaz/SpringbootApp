package com.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	@GetMapping("/")   
	public String index() {
		return "Greetings from Spring Boot!";
	}
	@GetMapping("/api/home")
    public String homeInit() {
        System.out.println("home controller");
        return "Welcome to HOME page of your application.. Alhumdulilah";
    }
}
