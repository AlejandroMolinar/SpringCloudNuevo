package com.microservices.app.student.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.microservices.commons.students.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
    
    @Query("select s from Student s where s.name like %?1% or s.lastname like %?1%")
    public List<Student> findByNameOrLastname(String nameOrLastname);

}