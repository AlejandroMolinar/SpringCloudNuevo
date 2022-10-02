package com.microservices.app.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.app.microservices.commons.students.models.entity"})
public class MicroservicesUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesUserApplication.class, args);
	}
	
}
