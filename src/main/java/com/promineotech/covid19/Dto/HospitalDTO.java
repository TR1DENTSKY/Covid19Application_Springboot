package com.promineotech.covid19.Dto;

import java.util.List;

public class HospitalDTO {
    private Long id;
    private String name;
    private String location;
    private List<AdmissionDTO> admissionDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<AdmissionDTO> getAdmissionDTOS() {
        return admissionDTOS;
    }

    public void setAdmissionDTOS(List<AdmissionDTO> admissionDTOS) {
        this.admissionDTOS = admissionDTOS;
    }
}
