package com.promineotech.covid19.transformer;

import com.promineotech.covid19.Dto.AdmissionDTO;
import com.promineotech.covid19.Dto.PatientDTO;
import com.promineotech.covid19.Dto.TestDTO;
import com.promineotech.covid19.Dto.UserDTO;
import com.promineotech.covid19.entity.Admission;
import com.promineotech.covid19.entity.Patient;
import com.promineotech.covid19.entity.User;

import java.util.ArrayList;
import java.util.List;

public class PatientTransformer {
    public static List<PatientDTO> getPatientList(List<Patient> patients){
        List<PatientDTO> patientDTOS=new ArrayList<>();
        for(int i=0; i<patients.size(); i++){
            Patient patient=patients.get(i);
            PatientDTO patientDTO=new PatientDTO();

            patientDTO.setFirstName(patient.getFirstName());
            patientDTO.setLastName(patient.getLastName());
            patientDTO.setDob(patient.getDob());
            patientDTO.setGender(patient.getGender());
            patientDTO.setId(patient.getId());
            System.out.println(patient.getTest());
            List<TestDTO> testDTOS=new ArrayList<>();
            if(patient.getTest()!=null){
                for(int j=0; j<patient.getTest().size(); j++){
                    TestDTO testDTO=new TestDTO();
                    if(patient.getTest().get(j).getDate()!=null){
                        testDTO.setDate(patient.getTest().get(j).getDate());
                    }
                    if(patient.getTest().get(j).getSite()!=null){
                        testDTO.setSite(patient.getTest().get(j).getSite());
                    }
                    if(patient.getTest().get(j).getId()!=null){
                        testDTO.setId(patient.getTest().get(j).getId());
                    }
                        testDTO.setResult(patient.getTest().get(j).getResult());
                    testDTOS.add(testDTO);
                }
            }
            List<UserDTO> usersDtos=new ArrayList<>();
            if(patient.getUser()!=null){
                for(int k=0; k<patient.getUser().size(); k++){
                    User user=patient.getUser().get(k);
                    UserDTO userDTO=new UserDTO();
                    usersDtos.add(UserTransformer.getUserDTO(user));
                }
            }
            List<AdmissionDTO> admissionDTOS=new ArrayList<>();
            if(patient.getAddmission()!=null){
                for(int k=0; k<patient.getAddmission().size(); k++){
                    Admission admission=patient.getAddmission().get(k);
                    admissionDTOS.add(AdmissionTransformer.getAdmissionDTO(admission));
                }
            }
            patientDTO.setAdmissionDTOS(admissionDTOS);
            patientDTO.setUserDTOSet(usersDtos);
            patientDTO.setTest(testDTOS);
            patientDTOS.add(patientDTO);
        }
        return patientDTOS;
    }

    public static PatientDTO getPatientDTO(Patient patient){
            PatientDTO patientDTO=new PatientDTO();
            patientDTO.setFirstName(patient.getFirstName());
            patientDTO.setLastName(patient.getLastName());
            patientDTO.setDob(patient.getDob());
            patientDTO.setGender(patient.getGender());
            patientDTO.setId(patient.getId());
            List<TestDTO> testDTOS=new ArrayList<>();
            if(patient.getTest()!=null){
                for(int j=0; j<patient.getTest().size(); j++){
                    TestDTO testDTO=new TestDTO();
                    if(patient.getTest().get(j).getDate()!=null){
                        testDTO.setDate(patient.getTest().get(j).getDate());
                    }
                    if(patient.getTest().get(j).getSite()!=null){
                        testDTO.setSite(patient.getTest().get(j).getSite());
                    }
                    if(patient.getTest().get(j).getId()!=null){
                        testDTO.setId(patient.getTest().get(j).getId());
                    }
                    testDTO.setResult(patient.getTest().get(j).getResult());
                    testDTOS.add(testDTO);
                }
            }
        List<UserDTO> usersDtos=new ArrayList<>();
        if(patient.getUser()!=null){
            for(int k=0; k<patient.getUser().size(); k++){
                User user=patient.getUser().get(k);
                UserDTO userDTO=new UserDTO();
                usersDtos.add(UserTransformer.getUserDTO(user));
            }
        }
        List<AdmissionDTO> admissionDTOS=new ArrayList<>();
        if(patient.getAddmission()!=null){
            for(int k=0; k<patient.getAddmission().size(); k++){
                Admission admission=patient.getAddmission().get(k);
                admissionDTOS.add(AdmissionTransformer.getAdmissionDTO(admission));
            }
        }
        patientDTO.setAdmissionDTOS(admissionDTOS);
        patientDTO.setUserDTOSet(usersDtos);
        patientDTO.setTest(testDTOS);
        return patientDTO;
    }


    public static PatientDTO getPatientDTOOnly(Patient patient){
        PatientDTO patientDTO=new PatientDTO();
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setDob(patient.getDob());
        patientDTO.setGender(patient.getGender());
        patientDTO.setId(patient.getId());
        return patientDTO;
    }


    public static PatientDTO getPatientDTOForHospital(Patient patient){
        PatientDTO patientDTO=new PatientDTO();
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setDob(patient.getDob());
        patientDTO.setGender(patient.getGender());
        patientDTO.setId(patient.getId());
        List<TestDTO> testDTOS=new ArrayList<>();
        if(patient.getTest()!=null){
            for(int j=0; j<patient.getTest().size(); j++){
                TestDTO testDTO=new TestDTO();
                if(patient.getTest().get(j).getDate()!=null){
                    testDTO.setDate(patient.getTest().get(j).getDate());
                }
                if(patient.getTest().get(j).getSite()!=null){
                    testDTO.setSite(patient.getTest().get(j).getSite());
                }
                if(patient.getTest().get(j).getId()!=null){
                    testDTO.setId(patient.getTest().get(j).getId());
                }
                testDTO.setResult(patient.getTest().get(j).getResult());
                testDTOS.add(testDTO);
            }
        }
        List<UserDTO> usersDtos=new ArrayList<>();
        if(patient.getUser()!=null){
            for(int k=0; k<patient.getUser().size(); k++){
                User user=patient.getUser().get(k);
                UserDTO userDTO=new UserDTO();
                usersDtos.add(UserTransformer.getUserDTO(user));
            }
        }
        patientDTO.setUserDTOSet(usersDtos);
        patientDTO.setTest(testDTOS);
        return patientDTO;
    }

    public static PatientDTO getPatientDTOForUser(Patient patient){
        PatientDTO patientDTO=new PatientDTO();
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setDob(patient.getDob());
        patientDTO.setGender(patient.getGender());
        patientDTO.setId(patient.getId());
        List<TestDTO> testDTOS=new ArrayList<>();
        if(patient.getTest()!=null){
            for(int j=0; j<patient.getTest().size(); j++){
                TestDTO testDTO=new TestDTO();
                if(patient.getTest().get(j).getDate()!=null){
                    testDTO.setDate(patient.getTest().get(j).getDate());
                }
                if(patient.getTest().get(j).getSite()!=null){
                    testDTO.setSite(patient.getTest().get(j).getSite());
                }
                if(patient.getTest().get(j).getId()!=null){
                    testDTO.setId(patient.getTest().get(j).getId());
                }
                testDTO.setResult(patient.getTest().get(j).getResult());
                testDTOS.add(testDTO);
            }
        }

        List<AdmissionDTO> admissionDTOS=new ArrayList<>();
        if(patient.getAddmission()!=null){
            for(int k=0; k<patient.getAddmission().size(); k++){
                Admission admission=patient.getAddmission().get(k);
                admissionDTOS.add(AdmissionTransformer.getAdmissionDTO(admission));
            }
        }
        patientDTO.setAdmissionDTOS(admissionDTOS);
        patientDTO.setTest(testDTOS);
        return patientDTO;
    }
}
