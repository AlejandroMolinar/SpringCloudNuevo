package com.microservices.app.user.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.user.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
    
}