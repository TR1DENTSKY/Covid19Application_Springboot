package com.promineotech.covid19.transformer;

import com.promineotech.covid19.Dto.AdmissionDTO;
import com.promineotech.covid19.Dto.HospitalDTO;
import com.promineotech.covid19.entity.Admission;
import com.promineotech.covid19.entity.Hospital;

import java.util.ArrayList;
import java.util.List;

public class HospitalTransformer {
    public static HospitalDTO getHospitalDTO(Hospital hospital){
        HospitalDTO hospitalDTO=new HospitalDTO();
        if(hospital.getName()!=null){
            hospitalDTO.setName(hospital.getName());
        }
        if(hospital.getLocation()!=null){
            hospitalDTO.setLocation(hospital.getLocation());
        }
        if(hospital.getId()!=null){
            hospitalDTO.setId(hospital.getId());
        }
        return hospitalDTO;
    }

    public static HospitalDTO getHospitalDTOForAdmission(Hospital hospital){
        HospitalDTO hospitalDTO=new HospitalDTO();
        if(hospital.getName()!=null){
            hospitalDTO.setName(hospital.getName());
        }
        if(hospital.getLocation()!=null){
            hospitalDTO.setLocation(hospital.getLocation());
        }
        if(hospital.getId()!=null){
            hospitalDTO.setId(hospital.getId());
        }
        List<AdmissionDTO> admissionDTOList=new ArrayList<>();
        if(hospital.getAdmission()!=null){
            for(int i=0; i<hospital.getAdmission().size(); i++){
                Admission admission=hospital.getAdmission().get(i);
                admissionDTOList.add(AdmissionTransformer.getAdmissionDTOForHospital(admission));
            }
        }
        hospitalDTO.setAdmissionDTOS(admissionDTOList);
        return hospitalDTO;
    }

    public static List<HospitalDTO> getHospitalDTOS(List<Hospital> hospitals){
        List<HospitalDTO> hospitalDTOS=new ArrayList<>();
        for (int i=0; i<hospitals.size(); i++){
            Hospital hospital=hospitals.get(i);
            hospitalDTOS.add(HospitalTransformer.getHospitalDTOForAdmission(hospital));
        }
        return hospitalDTOS;
    }
}
