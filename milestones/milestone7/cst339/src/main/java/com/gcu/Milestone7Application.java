package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Main application class
@SpringBootApplication
@ComponentScan({ "com.gcu" })
public class Milestone7Application {

	public static void main(String[] args) {
		SpringApplication.run(Milestone7Application.class, args);
	}

}
