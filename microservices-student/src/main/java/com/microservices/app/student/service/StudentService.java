package com.microservices.app.student.service;

import java.util.List;

import com.app.microservices.commons.students.models.entity.Student;
import com.microservices.app.commons.service.CommonService;

public interface StudentService extends CommonService<Student>{
    
    public List<Student> findByNameOrLastname(String nameOrLastname);
    
}