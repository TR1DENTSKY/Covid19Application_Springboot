package com.promineotech.covid19.repository;

import com.promineotech.covid19.entity.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test,Long> {
}
