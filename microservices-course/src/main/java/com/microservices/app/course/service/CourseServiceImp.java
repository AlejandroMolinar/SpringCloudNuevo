package com.microservices.app.user.service;

import org.springframework.stereotype.Service;

import com.microservices.app.commons.service.CommonServiceImp;
import com.microservices.app.user.models.entity.Student;
import com.microservices.app.user.models.repository.StudentRepository;

@Service
public class StudentServiceImp extends CommonServiceImp<Student, StudentRepository>
        implements StudentService {


}
