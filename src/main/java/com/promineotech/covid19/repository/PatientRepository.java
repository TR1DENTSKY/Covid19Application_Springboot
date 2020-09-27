package com.promineotech.covid19.repository;

import com.promineotech.covid19.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient,Long> {
    List<Patient> findAll();
}
