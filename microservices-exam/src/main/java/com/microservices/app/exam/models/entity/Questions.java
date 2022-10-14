package com.microservices.app.exam.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "questions")
public class Questions {

    // -----------------------------------------------------------------------------------
    // GeneratedValue(strategy = GenerationType.IDENTITY) -> Id autoincrementable
    //
    // Temporal(TemporalType.TIMESTAMP) -> Tiempo completo, fecha y hora
    // -----------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String text;

    /*******************************************************
     * JoinColumn -> Establece una llave Foranea con Exams *
     *******************************************************/
    @JsonIgnoreProperties(value = "questions", allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private List<Exams> exams;

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

    public Questions() {
        this.exams = new ArrayList<Exams>();
    }

    // -------------------------Getter-and-Setter------------------------------------------

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String name) {
        this.text = name;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public List<Exams> getExams() {
        return exams;
    }

    public void setExams(List<Exams> exams) {
        this.exams = exams;
    }

    
}
