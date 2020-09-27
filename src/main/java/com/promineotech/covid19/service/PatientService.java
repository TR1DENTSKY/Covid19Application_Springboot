package com.promineotech.covid19.service;
import com.promineotech.covid19.entity.Patient;
import com.promineotech.covid19.repository.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private static final Logger logger = LogManager.getLogger(PatientService.class);

    @Autowired
    private PatientRepository repo;

    public Patient createPatient(Patient patient) {
        return repo.save(patient);
    }

    public Patient getPatient(Long id) {
        Optional<Patient> patient=repo.findById(id);
        if(patient.isPresent()){
            Patient patient1=patient.get();
            return patient1;
        }
        return null;
    }

    public List<Patient> getPatient(){
        return repo.findAll();
    }

    public Patient updatePatient(Patient patient, Long id) throws Exception {
        try {
            Patient oldPatient = new Patient();
            Optional<Patient> patient1=repo.findById(id);
            if(patient1.isPresent()){
                oldPatient=patient1.get();
            }
            oldPatient.setFirstName(patient.getFirstName());
            oldPatient.setLastName(patient.getLastName());
            oldPatient.setDob(patient.getDob());
            oldPatient.setGender(patient.getGender());
            //oldPatient.setAddmission(patient.getAddmission());
            //oldPatient.setUser(patient.getUser());
           // oldPatient.setTest(patient.getTest());
            return repo.save(oldPatient);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to update patient: " + id, e);
            throw new Exception("Unable to update patient.");
        }
    }

    public void deletePatient(Long id) throws Exception {
        try {
            Patient oldPatient = new Patient();
            Optional<Patient> patient1=repo.findById(id);
            if(patient1.isPresent()){
                oldPatient=patient1.get();
            }
            repo.delete(oldPatient);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to delete patient: " + id, e);
            throw new Exception("Unable to delete patient.");
        }
    }
}
