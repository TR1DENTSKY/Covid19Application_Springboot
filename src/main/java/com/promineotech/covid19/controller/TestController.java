package com.promineotech.covid19.controller;

import com.promineotech.covid19.entity.Test;
import com.promineotech.covid19.service.TestService;
import com.promineotech.covid19.transformer.TestTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService service;

    @PostMapping("/create")
    public ResponseEntity<Object> createTest(@ModelAttribute Test test){
        return new ResponseEntity<Object>(service.createTest(test), HttpStatus.CREATED);
    }

    @GetMapping("/getAllTests")
    public ResponseEntity<Object> getTest(){
        List<Test> test= (List<Test>) service.getTest();
        return new ResponseEntity<Object>(TestTransformer.getTestDTOS(test), HttpStatus.OK);
    }

    @GetMapping(value="/getTestById/{id}")
    public ResponseEntity<Object> getTestById(@PathVariable Long id){
        Test test=service.getTest(id);
        return new ResponseEntity<Object>(TestTransformer.getTestDTO(test), HttpStatus.OK);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<Object> updateTest(@ModelAttribute Test test, @PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.updateTest(test, id), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to update test.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> deleteTest(@PathVariable Long id){
        try {
            service.deleteTest(id);
            return new ResponseEntity<Object>("Deleted test with id: " + id, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to delete test.", HttpStatus.BAD_REQUEST);
        }
    }
}
