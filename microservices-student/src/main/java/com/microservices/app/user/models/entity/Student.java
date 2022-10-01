package com.microservices.app.user.models.entity;

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
@Table(name = "students")
public class Student {

    // -----------------------------------------------------------------------------------
    // GeneratedValue(strategy = GenerationType.IDENTITY) -> Id autoincrementable
    //
    // Temporal(TemporalType.TIMESTAMP)     -> Tiempo completo, fecha y hora
    // -----------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String lastname;
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date create;

    @PrePersist
    public void prePersist() {
        //Guarda la fecha de la creación
        this.create= new Date();
    }

// -------------------------Getter and Setter------------------------------------------

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

}
