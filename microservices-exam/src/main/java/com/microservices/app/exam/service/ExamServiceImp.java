package com.microservices.app.exam.service;

import org.springframework.stereotype.Service;

import com.microservices.app.commons.service.CommonServiceImp;
import com.microservices.app.exam.models.entity.Exams;
import com.microservices.app.exam.models.repository.ExamRepository;

@Service 
public class ExamServiceImp extends CommonServiceImp<Exams, ExamRepository>implements ExamService {

}
