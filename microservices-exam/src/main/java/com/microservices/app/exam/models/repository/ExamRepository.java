package com.microservices.app.exam.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.commons.exams.models.entity.Exams;

public interface ExamRepository extends CrudRepository<Exams, Long>{
    
}