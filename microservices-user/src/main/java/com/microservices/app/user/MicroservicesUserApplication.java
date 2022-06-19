package com.microservices.app.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicesUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesUserApplication.class, args);
	}
	
}
