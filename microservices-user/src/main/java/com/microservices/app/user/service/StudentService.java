package com.microservices.app.user.service;

import java.util.Optional;

import com.microservices.app.user.models.entity.Student;

public interface StudentService{

    public Iterable<Student> findAll();

    public Optional<Student> findById(Long id);

    public Student save(Student student);

    public void deleteByID(Long id);
    
}