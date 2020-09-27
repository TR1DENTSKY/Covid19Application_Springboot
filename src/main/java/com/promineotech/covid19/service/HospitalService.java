package com.promineotech.covid19.service;

import com.promineotech.covid19.repository.HospitalRepository;
import com.promineotech.covid19.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
@Service
public class HospitalService {

    private static final Logger logger = LogManager.getLogger(HospitalService.class);

    @Autowired
    private HospitalRepository repo;

    public Hospital createHospital(Hospital hospital) {
        return repo.save(hospital);
    }

    public Hospital getHospital(Long id) {
        Optional<Hospital> hospital=repo.findById(id);
        if(hospital.isPresent()){
            Hospital hospital1=hospital.get();
            return hospital1;
        }
        return null;
    }

    public List<Hospital> getHospital(){
        return repo.findAll();
    }

    public Hospital updateHospital(Hospital hospital, Long id) throws Exception {
        try {
            Hospital oldHospital = new Hospital();
            Optional<Hospital> hospital1=repo.findById(id);
            if(hospital1.isPresent()){
                oldHospital=hospital1.get();
            }
            oldHospital.setName(hospital.getName());
            oldHospital.setLocation(hospital.getLocation());
            //oldHospital.setAdmission(hospital.getAdmission());
            return repo.save(oldHospital);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to update hospital: " + id, e);
            throw new Exception("Unable to update hospital.");
        }
    }

    public void deleteHospital(Long id) throws Exception {
        try {
            Hospital oldHospital = new Hospital();
            Optional<Hospital> hospital1=repo.findById(id);
            if(hospital1.isPresent()){
                oldHospital=hospital1.get();
            }
            repo.delete(oldHospital);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to delete hospital: " + id, e);
            throw new Exception("Unable to delete hospital.");
        }
    }
}
