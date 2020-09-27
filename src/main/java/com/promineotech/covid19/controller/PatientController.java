package com.promineotech.covid19.controller;

import com.promineotech.covid19.Dto.PatientDTO;
import com.promineotech.covid19.entity.Patient;
import com.promineotech.covid19.service.PatientService;
import com.promineotech.covid19.transformer.PatientTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService service;

    @PostMapping("/create")
    public ResponseEntity<Object> createPatient(@ModelAttribute Patient patient){
        return new ResponseEntity<Object>(service.createPatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/getPatients")
    public List<PatientDTO> getPatients(){
        List<Patient> patients=service.getPatient();
        System.out.println("patient");
        for(int i=0; i<patients.size(); i++){
            Patient patient=patients.get(i);
            for(int j=0; j<patient.getTest().size(); j++){
                System.out.println(patient.getTest().get(j).getDate());
            }

        }
        return PatientTransformer.getPatientList(patients);
    }

    @GetMapping(value="getPatientById/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable Long id){
        Patient patient=service.getPatient(id);
        return new ResponseEntity<Object>(PatientTransformer.getPatientDTO(patient), HttpStatus.OK);
    }

    @PutMapping(value="update/{id}")
    public ResponseEntity<Object> updatePatient(@ModelAttribute Patient patient, @PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.updatePatient(patient, id), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to update patient.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable Long id){
        try {
            service.deletePatient(id);
            return new ResponseEntity<Object>("Deleted patient with id: " + id, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to delete patient.", HttpStatus.BAD_REQUEST);
        }
    }
}
