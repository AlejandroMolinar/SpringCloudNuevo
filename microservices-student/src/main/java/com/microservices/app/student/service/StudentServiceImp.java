package com.microservices.app.student.service;

import org.springframework.stereotype.Service;

import com.app.microservices.commons.students.models.entity.Student;
import com.microservices.app.commons.service.CommonServiceImp;
import com.microservices.app.student.models.repository.StudentRepository;

@Service
public class StudentServiceImp extends CommonServiceImp<Student, StudentRepository> implements StudentService {


}
