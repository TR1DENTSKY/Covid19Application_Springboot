package com.promineotech.covid19.transformer;

import com.promineotech.covid19.Dto.PatientDTO;
import com.promineotech.covid19.Dto.TestDTO;
import com.promineotech.covid19.entity.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTransformer {
    public static List<TestDTO> getTestDTOS(List<Test> tests){
        List<TestDTO> testDTOS=new ArrayList<>();
        for (int i=0; i<tests.size(); i++){
            Test test=tests.get(i);
            TestDTO testDTO=new TestDTO();
            testDTO.setId(test.getId());
            testDTO.setDate(test.getDate());
            testDTO.setSite(test.getSite());
            testDTO.setResult(test.getResult());
            if(test.getPatient()!=null){
                PatientDTO patientDTO=new PatientDTO();
                patientDTO.setId(test.getPatient().getId());
                patientDTO.setDob(test.getPatient().getDob());
                patientDTO.setGender(test.getPatient().getGender());
                patientDTO.setLastName(test.getPatient().getLastName());
                patientDTO.setFirstName(test.getPatient().getFirstName());
                testDTO.setPatient(patientDTO);
            }
            testDTOS.add(testDTO);
        }
        return  testDTOS;
    }
    public static TestDTO getTestDTO(Test test){
            TestDTO testDTO=new TestDTO();
            testDTO.setId(test.getId());
            testDTO.setDate(test.getDate());
            testDTO.setSite(test.getSite());
            testDTO.setResult(test.getResult());
            if(test.getPatient()!=null){
                PatientDTO patientDTO=new PatientDTO();
                patientDTO.setId(test.getPatient().getId());
                patientDTO.setDob(test.getPatient().getDob());
                patientDTO.setGender(test.getPatient().getGender());
                patientDTO.setLastName(test.getPatient().getLastName());
                patientDTO.setFirstName(test.getPatient().getFirstName());
                testDTO.setPatient(patientDTO);
            }
        return  testDTO;
    }
}
