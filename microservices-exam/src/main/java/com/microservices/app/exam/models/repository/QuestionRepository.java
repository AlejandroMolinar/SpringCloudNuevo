package com.microservices.app.exam.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.exam.models.entity.Questions;

public interface QuestionRepository extends CrudRepository<Questions, Long>{
    
}