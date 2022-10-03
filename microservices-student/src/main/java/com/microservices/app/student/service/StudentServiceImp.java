package com.microservices.app.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.microservices.commons.students.models.entity.Student;
import com.microservices.app.commons.service.CommonServiceImp;
import com.microservices.app.student.models.repository.StudentRepository;

@Service
public class StudentServiceImp extends CommonServiceImp<Student, StudentRepository> implements StudentService {

    /**********************************************************************************
     * Debido a que este metodo solo muestra datos, solo sera readOnly o solo lectura *
     **********************************************************************************/
    @Override
    @Transactional(readOnly = true)
    public List<Student> findByNameOrLastname(String nameOrLastname) {
        return repository.findByNameOrLastname(nameOrLastname);
    }


}
