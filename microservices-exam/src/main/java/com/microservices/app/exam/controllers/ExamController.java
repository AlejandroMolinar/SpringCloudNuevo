package com.microservices.app.exam.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.commons.controller.CommonController;
import com.microservices.app.exam.models.entity.Exams;
import com.microservices.app.exam.models.entity.Questions;
import com.microservices.app.exam.service.ExamService;

@RestController
public class ExamController extends CommonController<Exams, ExamService> {

    /*********************************************************************************
     * En los envios o Protocolos HTTP, cuando se quiere enviar un elemento a través
     * *
     * de un link, se agrega "{}" y la variable adentro. *
     * @PutMapping("/{id}") <-- En este caso se envia el Id, variable numerica *
     *********************************************************************************/

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Exams exam, @PathVariable Long id) {

        Optional<Exams> optional = service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Exams examdb = optional.get();
        examdb.setName(exam.getName());

        /****************************************************
         * Eliminar o Agregadas preguntar borradas/editadas *
         ****************************************************/
        List<Questions> remove = new ArrayList<>();

        examdb.getQuestions().forEach(question ->{
            /***********************************************************************************
             * Si el examen mandado por el body, no contiene una pregunta guardada en la BBDD, *
             * entonces se guardara en la lista "remove", para borrarla mas adelante.          *
             ***********************************************************************************/
            if (!exam.getQuestions().contains(question)) {
                remove.add(question);
            }
        });

        remove.forEach(examdb::deleteQuestion);
        examdb.setQuestions(exam.getQuestions());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examdb));
    }

}
