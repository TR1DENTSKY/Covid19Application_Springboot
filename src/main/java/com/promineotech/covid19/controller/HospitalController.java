package com.promineotech.covid19.controller;

import com.promineotech.covid19.service.HospitalService;
import com.promineotech.covid19.entity.Hospital;
import com.promineotech.covid19.transformer.HospitalTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService service;

    @PostMapping("/create")
    public ResponseEntity<Object> createHospital(@ModelAttribute Hospital hospital){
        return new ResponseEntity<Object>(service.createHospital(hospital), HttpStatus.CREATED);
    }

    @GetMapping("/getHospitals")
    public ResponseEntity<Object> getHospital(){
        List<Hospital> hospitals=service.getHospital();
        return new ResponseEntity<Object>(HospitalTransformer.getHospitalDTOS(hospitals), HttpStatus.OK);
    }

    @GetMapping(value="/getHospitalById/{id}")
    public ResponseEntity<Object> getHospitalById(@PathVariable Long id){
        Hospital hospital=service.getHospital(id);
        return new ResponseEntity<Object>(HospitalTransformer.getHospitalDTOForAdmission(hospital), HttpStatus.OK);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<Object> updateHospital(@ModelAttribute Hospital hospital, @PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.updateHospital(hospital, id), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to update hospital.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> deleteHospital(@PathVariable Long id){
        try {
            service.deleteHospital(id);
            return new ResponseEntity<Object>("Deleted hospital with id: " + id, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to delete hospital.", HttpStatus.BAD_REQUEST);
        }
    }
}
