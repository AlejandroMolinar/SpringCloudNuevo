package com.microservices.app.commons.exams.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.commons.exams.models.entity.Questions;

public interface QuestionRepository extends CrudRepository<Questions, Long>{
    
}