package com.promineotech.covid19.Dto;

import java.util.List;

public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String dob;
    private char gender;
    private List<TestDTO> test;
    private List<UserDTO> userDTOSet;
    private List<AdmissionDTO> admissionDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public List<TestDTO> getTest() {
        return test;
    }

    public void setTest(List<TestDTO> test) {
        this.test = test;
    }

    public List<UserDTO> getUserDTOSet() {
        return userDTOSet;
    }

    public void setUserDTOSet(List<UserDTO> userDTOSet) {
        this.userDTOSet = userDTOSet;
    }

    public List<AdmissionDTO> getAdmissionDTOS() {
        return admissionDTOS;
    }

    public void setAdmissionDTOS(List<AdmissionDTO> admissionDTOS) {
        this.admissionDTOS = admissionDTOS;
    }
}
