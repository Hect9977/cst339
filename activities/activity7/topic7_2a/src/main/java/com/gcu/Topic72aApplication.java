package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Topic72aApplication {

	public static void main(String[] args) {
		SpringApplication.run(Topic72aApplication.class, args);
	}

}
