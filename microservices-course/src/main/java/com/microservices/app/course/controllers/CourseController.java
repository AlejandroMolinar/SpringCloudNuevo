package com.microservices.app.course.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.commons.controller.CommonController;
import com.microservices.app.course.models.entity.Course;
import com.microservices.app.course.service.CourseService;

@RestController
public class CourseController extends CommonController<Course, CourseService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Course couse, @PathVariable Long id){
        
        Optional<Course> optional= service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();   
        }
        
        Course couse2= optional.get();
        couse2.setName(couse.getName());
        couse2.setLastname(couse.getLastname());
        couse2.setEmail(couse.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(couse2));
    }


}
