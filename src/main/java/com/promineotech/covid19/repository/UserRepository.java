package com.promineotech.covid19.repository;

import com.promineotech.covid19.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findAll();
}
