package com.microservices.app.commons.controller;

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

import com.microservices.app.commons.service.CommonService;

// @RestController
public class CommonController<E> {

    @Autowired
    private CommonService<E> service;

    // -----------------------------------------------------------------------------------
    //  Devuelve la lista completa de los estudiantes en un body. 
    // -----------------------------------------------------------------------------------
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Optional<E> optional= service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody E entity){
        E entity2= service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity2);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody E entity, @PathVariable Long id){
        
        Optional<E> optional= service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();  
        }
        
        E entity2= optional.get();
        // entity2.setName(entity.getName());
        // entity2.setLastname(entity.getLastname());
        // entity2.setEmail(entity.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity2));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

}
