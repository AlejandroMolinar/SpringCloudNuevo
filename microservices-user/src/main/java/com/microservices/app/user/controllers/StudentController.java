package com.microservices.app.user.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student){
        Student student2= service.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student2);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

}
