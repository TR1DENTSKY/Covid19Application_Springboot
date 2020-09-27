package com.promineotech.covid19.controller;

import com.promineotech.covid19.service.AdmissionService;
import com.promineotech.covid19.entity.Admission;
import com.promineotech.covid19.transformer.AdmissionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admission")
public class AdmissionController {
    @Autowired
    private AdmissionService service;

    @PostMapping("/create")
    public ResponseEntity<Object> createAdmission(@ModelAttribute Admission admission){
        return new ResponseEntity<Object>(service.createAdmission(admission), HttpStatus.CREATED);
    }

    @GetMapping("/getAdmissions")
    public ResponseEntity<Object> getAdmissions(){
        List<Admission> admissionList=service.getAdmissions();
        return new ResponseEntity<Object>(AdmissionTransformer.getAdmissionDTOList(admissionList), HttpStatus.OK);
    }

    @GetMapping(value="/getAdmissionById/{id}")
    public ResponseEntity<Object> getAdmissionById(@PathVariable Long id){
        Admission admission=service.getAdmission(id);
        return new ResponseEntity<Object>(AdmissionTransformer.getAdmissionDToForAdmision(admission), HttpStatus.OK);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<Object> updateAdmission(@ModelAttribute Admission admission, @PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(AdmissionTransformer.getAdmissionDToForAdmision(service.updateAdmission(admission, id)), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to update admission.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> deleteAdmission(@PathVariable Long id){
        try {
            service.deleteAdmission(id);
            return new ResponseEntity<Object>("Deleted admission with id: " + id, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to delete admission.", HttpStatus.BAD_REQUEST);
        }
    }
}
