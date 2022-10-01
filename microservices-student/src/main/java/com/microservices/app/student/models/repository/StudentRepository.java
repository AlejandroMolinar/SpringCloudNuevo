package com.microservices.app.student.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.microservices.commons.students.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
    
}