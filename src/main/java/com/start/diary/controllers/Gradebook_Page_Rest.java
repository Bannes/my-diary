package com.start.diary.controllers;

import com.start.diary.entities.dto.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class Gradebook_Page_Rest {

    @GetMapping("/getListOfSubjectForCertainClassRoom/{classNumber}/{classLetter}")
    public ResponseEntity<Object> getListOfSubjectForCertainClassRoom(@PathVariable int classNumber) {

        /*ServiceResponse<Set<String>> response= myPageCreateGradeBookRestService.getListOfClassLetters(classNumber);*/

        return null;
    }

}