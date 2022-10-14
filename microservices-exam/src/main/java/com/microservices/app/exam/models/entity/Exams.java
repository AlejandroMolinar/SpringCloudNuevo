package com.microservices.app.exam.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    /****************************************************************************************
     * One -> Exam                                                                          *
     * Many -> Questions                                                                    *
     * -------------------------------------------------------------------------------------*
     * CascadeType.PERSIST -> Se guardara en la BBDD los examenes y las preguntas en comun  *
     * CascadeType.REMOVE -> Eliminara los examenes y preguntas relacionadas                *
     * CascadeType.ALL -> GUardara o Elimina todos los elementos relacionados               *
     * -------------------------------------------------------------------------------------*
     * orphanRemoval = true -> Eliminara los elementos que no tengan relacion o sea null    *
     * mappedBy = "NombreElemento" -> Para la relacion Bidireccional con Questions          *
     * -------------------------------------------------------------------------------------*
     * JsonIgnoreProperties -> Evita las creaciones de relaciones constantes, si ya hubo    *
     * relacion en questions, exams no ejecuta las relaciones entre ellas.                  *
     * allowSetters -> Permite que se pueda utilizar los Setter de la lista                 *
     ****************************************************************************************/
    @JsonIgnoreProperties(value = "exams", allowSetters = true)
    @OneToMany(mappedBy = "exams" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questions> questions;  

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

    public Exams() {
        this.questions = new ArrayList<>();
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

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions.clear();
        questions.forEach(this::addQuestion);
    }

    public void addQuestion(Questions question) {
        this.questions.add(question);
        question.setExams(this);
    }
    
    public void deleteQuestion(Questions question) {
        this.questions.remove(question);  
        question.setExams(null);
    }
}
