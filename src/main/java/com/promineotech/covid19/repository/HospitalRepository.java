package com.promineotech.covid19.repository;

import com.promineotech.covid19.entity.Hospital;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HospitalRepository extends CrudRepository<Hospital,Long> {
    List<Hospital> findAll();
}
