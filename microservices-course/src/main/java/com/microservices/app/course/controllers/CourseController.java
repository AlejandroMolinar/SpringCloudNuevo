package com.microservices.app.course.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservices.commons.students.models.entity.Student;
import com.microservices.app.commons.controller.CommonController;
import com.microservices.app.course.models.entity.Course;
import com.microservices.app.course.service.CourseService;

@RestController
public class CourseController extends CommonController<Course, CourseService> {

    /*********************************************************************************
     * En los envios o Protocolos HTTP, cuando se quiere enviar un elemento a través *
     * de un link, se agrega "{}" y la variable adentro.                             *
     *  @PutMapping("/{id}") <-- En este caso se envia el Id, variable numerica      *
     *********************************************************************************/

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Course couse, @PathVariable Long id) {

        Optional<Course> optional = service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Course coursedb = optional.get();
        coursedb.setName(couse.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(coursedb));
    }

    @PutMapping("/{id}/add-students")
    public ResponseEntity<?> addStudents(@RequestBody List<Student> students, @PathVariable Long id) {
        
        Optional<Course> optional = service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Course coursedb = optional.get();
        // cousedb.setStudent(students);
        students.forEach(st -> coursedb.addStudent(st));

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(coursedb));

    }
    
    @PutMapping("/{id}/delete-students")
    public ResponseEntity<?> deleteStudents(@RequestBody Student student, @PathVariable Long id) {
        
        Optional<Course> optional = service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Course coursedb = optional.get();
        coursedb.deleteStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(coursedb));

    }
    
}
