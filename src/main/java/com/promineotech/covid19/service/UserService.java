package com.promineotech.covid19.service;

import com.promineotech.covid19.entity.User;
import com.promineotech.covid19.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository repo;

    public User createUser(User user) {
        return repo.save(user);
    }

    public User getUser(Long id) {
        Optional<User> user=repo.findById(id);
        if(user.isPresent()){
            User user1=user.get();
            return user1;
        }
        return null;
    }

    public List<User> getUsers(){
        return repo.findAll();
    }

    public User updateUser(User user, Long id) throws Exception {
        try {
            User oldUser = new User();
            Optional<User> user1=repo.findById(id);
            if(user1.isPresent()){
                oldUser=user1.get();
            }
            oldUser.setUsername(user.getUsername());
            oldUser.setEmail(user.getEmail());
            oldUser.setAddress(user.getAddress());
            oldUser.setPhoneNumber(user.getPhoneNumber());
            oldUser.setPatient(user.getPatient());
            return repo.save(oldUser);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to update user: " + id, e);
            throw new Exception("Unable to update user.");
        }
    }

    public void deleteUser(Long id) throws Exception {
        try {
            User oldUser = new User();
            Optional<User> user1=repo.findById(id);
            if(user1.isPresent()){
                oldUser=user1.get();
            }
            repo.delete(oldUser);
        } catch(Exception e) {
            logger.error("There was an issue that occurred while trying to delete user: " + id, e);
            throw new Exception("Unable to delete user.");
        }
    }
}
