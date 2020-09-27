package com.promineotech.covid19.service;
import com.promineotech.covid19.entity.Test;
import com.promineotech.covid19.repository.TestRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {
    private static final Logger logger = LogManager.getLogger(TestService.class);

    @Autowired
    private TestRepository repo;

    public Test createTest(Test test) {
        return repo.save(test);
    }

    public Test getTest(Long id) {
        Optional<Test> test=repo.findById(id);
        if(test.isPresent()){
            Test test1=test.get();
            return test1;
        }
        return null;
    }

    public Iterable<Test> getTest(){
        return repo.findAll();
    }

    public Test updateTest(Test test, Long id) throws Exception {
        try {
            Test oldTest = new Test();
            Optional<Test> test1=repo.findById(id);
            if(test1.isPresent()){
                oldTest=test1.get();
            }
            oldTest.setDate(test.getDate());
            oldTest.setSite(test.getSite());
            oldTest.setResult(test.getResult());
            oldTest.setPatient(test.getPatient());
            return repo.save(oldTest);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to update test: " + id, e);
            throw new Exception("Unable to update test.");
        }
    }

    public void deleteTest(Long id) throws Exception {
        try {
            Test oldTest = new Test();
            Optional<Test> test1=repo.findById(id);
            if(test1.isPresent()){
                oldTest=test1.get();
            }
            repo.delete(oldTest);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to delete test: " + id, e);
            throw new Exception("Unable to delete test.");
        }
    }
}
