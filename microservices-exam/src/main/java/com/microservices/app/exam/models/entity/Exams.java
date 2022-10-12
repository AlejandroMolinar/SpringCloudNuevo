package com.microservices.app.exam.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "exams")
public class Exams {

    // -----------------------------------------------------------------------------------
    // GeneratedValue(strategy = GenerationType.IDENTITY) -> Id autoincrementable
    //
    // Temporal(TemporalType.TIMESTAMP) -> Tiempo completo, fecha y hora
    // -----------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    // @OneToMany(fetch = FetchType.LAZY)
    // private List<Course> courseList;

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

    // public Exam() {
    //     this.student = new ArrayList<Student>();
    // }

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


}
