package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Main application class
/**
 * Main Spring Boot entry point for the CST-339 Milestone 8 application.
 */
@SpringBootApplication
@ComponentScan({ "com.gcu" })
public class Milestone8Application {

	/**
	 * Launches the Spring Boot application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Milestone8Application.class, args);
	}

}
