package com.microservices.app.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/************************************************************************
 * ENTITYSCAN SE UTILIZA PARA ESPECIFICAR EL ENTITY Y DONDE ENCONTRARLO *
 ************************************************************************/

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.microservices.app.course.models.entity",
		"com.app.microservices.commons.students.models.entity" })
public class MicroservicesCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCourseApplication.class, args);
	}

}
