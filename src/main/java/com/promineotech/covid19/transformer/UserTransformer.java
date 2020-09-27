package com.promineotech.covid19.transformer;

import com.promineotech.covid19.Dto.UserDTO;
import com.promineotech.covid19.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserTransformer {
    public static UserDTO getUserDTO(User user){
        UserDTO userDTO=new UserDTO();
        if(user.getEmail()!=null){
            userDTO.setEmail(user.getEmail());
        }
        if(user.getAddress()!=null){
            userDTO.setAddress(user.getAddress());
        }
        if(user.getPhoneNumber()!=null){
            userDTO.setPhoneNumber(user.getPhoneNumber());
        }
        if(user.getUsername()!=null){
            userDTO.setUsername(user.getUsername());
        }
        if(user.getId()!=null){
            userDTO.setId(user.getId());
        }
        if(user.getPassword()!=null){
            userDTO.setPassword(user.getPassword());
        }
        return userDTO;
    }

    public static UserDTO getUserDTOForUser(User user){
        UserDTO userDTO=new UserDTO();
        if(user.getEmail()!=null){
            userDTO.setEmail(user.getEmail());
        }
        if(user.getAddress()!=null){
            userDTO.setAddress(user.getAddress());
        }
        if(user.getPhoneNumber()!=null){
            userDTO.setPhoneNumber(user.getPhoneNumber());
        }
        if(user.getUsername()!=null){
            userDTO.setUsername(user.getUsername());
        }
        if(user.getId()!=null){
            userDTO.setId(user.getId());
        }
        if(user.getPassword()!=null){
            userDTO.setPassword(user.getPassword());
        }
        if(user.getPatient()!=null){
            userDTO.setPatientDTO(PatientTransformer.getPatientDTOForUser(user.getPatient()));
        }
        return userDTO;
    }

    public static List<UserDTO> getUserDTOS(List<User> users){
        List<UserDTO> userDTOS=new ArrayList<>();
        for(int i=0; i<users.size(); i++){
            userDTOS.add(UserTransformer.getUserDTOForUser(users.get(i)));
        }
        return userDTOS;
    }
}
