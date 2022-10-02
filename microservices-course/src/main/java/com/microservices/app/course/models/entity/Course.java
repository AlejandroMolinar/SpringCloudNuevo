package com.microservices.app.course.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.app.microservices.commons.students.models.entity.Student;

@Entity
@Table(name = "couse")
public class Course {

    // -----------------------------------------------------------------------------------
    // GeneratedValue(strategy = GenerationType.IDENTITY) -> Id autoincrementable
    //
    // Temporal(TemporalType.TIMESTAMP) -> Tiempo completo, fecha y hora
    // -----------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> student;

    // @Column(name ="createAt") -- si no se pone, se agrega a la BBDD el nombre
    // original "create"
    @Temporal(TemporalType.TIMESTAMP)
    private Date create;

    @PrePersist
    public void prePersist() {
        // Guarda la fecha de la creación
        this.create = new Date();
    }
    // ------------------------Constructor-------------------------------------------------

    public Course() {
        this.student = new ArrayList<Student>();
    }

    // -------------------------Getter-and-Setter------------------------------------------

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public void addStudent(Student student) {
        this.student.add(student);
    }
    
    public void deleteStudent(Student student) {
        this.student.delete(student);   
    }

}
