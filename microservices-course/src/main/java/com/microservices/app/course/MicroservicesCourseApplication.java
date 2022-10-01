package com.microservices.app.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicroservicesCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCourseApplication.class, args);
	}

}
