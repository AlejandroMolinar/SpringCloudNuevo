package com.microservices.app.exam.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.commons.controller.CommonController;
import com.microservices.app.exam.models.entity.Exam;
import com.microservices.app.exam.service.ExamService;

@RestController
public class ExamController extends CommonController<Exam, ExamService> {

    /*********************************************************************************
     * En los envios o Protocolos HTTP, cuando se quiere enviar un elemento a través *
     * de un link, se agrega "{}" y la variable adentro.                             *
     *  @PutMapping("/{id}") <-- En este caso se envia el Id, variable numerica      *
     *********************************************************************************/

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Exam couse, @PathVariable Long id) {

        Optional<Exam> optional = service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Exam coursedb = optional.get();
        coursedb.setName(couse.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(coursedb));
    }

}
