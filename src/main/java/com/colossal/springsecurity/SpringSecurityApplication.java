package com.colossal.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(SpringSecurityApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "postgresql"));
		app.run(args);
	}

}
