package com.microservices.app.user.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.user.models.entity.Student;
import com.microservices.app.user.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    // -----------------------------------------------------------------------------------
    //  Devuelve la lista completa de los estudiantes en un body. 
    // -----------------------------------------------------------------------------------
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        
        Optional<Student> optional= service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(optional.get());
    }
}
