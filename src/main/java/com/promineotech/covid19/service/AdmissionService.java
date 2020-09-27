package com.promineotech.covid19.service;

import com.promineotech.covid19.repository.AdmissionRepository;
import com.promineotech.covid19.entity.Admission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionService {
    private static final Logger logger = LogManager.getLogger(AdmissionService.class);

    @Autowired
    private AdmissionRepository repo;

    public Admission createAdmission(Admission admission) {
        return repo.save(admission);
    }

    public Admission getAdmission(Long id) {
        Optional<Admission> admission=repo.findById(id);
        if(admission.isPresent()){
            Admission admission1=admission.get();
            return admission1;
        }
        return null;
    }

    public List<Admission> getAdmissions(){
        return repo.findAll();
    }

    public Admission updateAdmission(Admission admission, Long id) throws Exception {
        try {
            Admission oldAdmission = new Admission();
            Optional<Admission> admission1=repo.findById(id);
            if(admission1.isPresent()){
                oldAdmission=admission1.get();
            }
            oldAdmission.setDate(admission.getDate());
            oldAdmission.setHospital(admission.getHospital());
            oldAdmission.setPatient(admission.getPatient());
            return repo.save(oldAdmission);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to update admission: " + id, e);
            throw new Exception("Unable to update admission.");
        }
    }

    public void deleteAdmission(Long id) throws Exception {
        try {
            Admission oldAdmission = new Admission();
            Optional<Admission> admission1=repo.findById(id);
            if(admission1.isPresent()){
                oldAdmission=admission1.get();
            }
            repo.delete(oldAdmission);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to delete admission: " + id, e);
            throw new Exception("Unable to delete admission.");
        }
    }
}
