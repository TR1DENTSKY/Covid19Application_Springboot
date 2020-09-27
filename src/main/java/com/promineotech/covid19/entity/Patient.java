package com.promineotech.covid19.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dob")
    private String dob;
    @Column(name = "gender")
    private char gender;
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "patient" , cascade = CascadeType.ALL)
    private List<Test> test;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "patient_id")
    private List<User> user;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "patient_id")
    private List<Admission> addmission;

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

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Admission> getAddmission() {
        return addmission;
    }

    public void setAddmission(List<Admission> addmission) {
        this.addmission = addmission;
    }

}
