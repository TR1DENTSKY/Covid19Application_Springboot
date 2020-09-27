package com.promineotech.covid19.repository;

import com.promineotech.covid19.entity.Admission;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdmissionRepository extends CrudRepository<Admission,Long> {
    List<Admission> findAll();
}
