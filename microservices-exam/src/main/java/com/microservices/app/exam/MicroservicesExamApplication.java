package com.microservices.app.exam.microservicesexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicesExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesExamApplication.class, args);
	}

}
