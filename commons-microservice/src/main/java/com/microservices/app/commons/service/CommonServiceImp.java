package com.microservices.app.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.app.user.models.entity.Student;
import com.microservices.app.user.models.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
    
    @Autowired
    private StudentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Student> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return repository.save(student);
    }
    
    @Override
    @Transactional
    public void deleteByID(Long id) {
        repository.deleteById(id);
    }

}
