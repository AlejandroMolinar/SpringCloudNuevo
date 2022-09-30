package com.microservices.app.course.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.course.models.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
    
}