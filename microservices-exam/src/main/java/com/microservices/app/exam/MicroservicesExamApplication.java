package com.microservices.app.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicesExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesExamApplication.class, args);
	}

}
