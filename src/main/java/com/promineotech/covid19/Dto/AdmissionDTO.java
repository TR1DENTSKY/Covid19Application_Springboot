package com.promineotech.covid19.Dto;

public class AdmissionDTO {
    private Long id;
    private String date;
    private PatientDTO patientDTO;
    private HospitalDTO hospitalDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public HospitalDTO getHospitalDTO() {
        return hospitalDTO;
    }

    public void setHospitalDTO(HospitalDTO hospitalDTO) {
        this.hospitalDTO = hospitalDTO;
    }
}
