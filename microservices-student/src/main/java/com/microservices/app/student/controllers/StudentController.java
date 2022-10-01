package com.microservices.app.user.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.commons.controller.CommonController;
import com.microservices.app.user.models.entity.Student;
import com.microservices.app.user.service.StudentService;

@RestController
public class StudentController extends CommonController<Student, StudentService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id){
        
        Optional<Student> optional= service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();   
        }
        
        Student student2= optional.get();
        student2.setName(student.getName());
        student2.setLastname(student.getLastname());
        student2.setEmail(student.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(student2));
    }


}
