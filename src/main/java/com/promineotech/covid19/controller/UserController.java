package com.promineotech.covid19.controller;

import com.promineotech.covid19.entity.User;
import com.promineotech.covid19.service.UserService;
import com.promineotech.covid19.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@ModelAttribute User user){
        return new ResponseEntity<Object>(service.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Object> getUsers(){
        List<User> userList=service.getUsers();
        return new ResponseEntity<Object>(UserTransformer.getUserDTOS(userList), HttpStatus.OK);
    }

    @GetMapping(value="/getUserById/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id){
        User user=service.getUser(id);
        return new ResponseEntity<Object>(UserTransformer.getUserDTOForUser(user), HttpStatus.OK);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<Object> updateUser(@ModelAttribute User user, @PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.updateUser(user, id), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to update user.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        try {
            service.deleteUser(id);
            return new ResponseEntity<Object>("Deleted user with id: " + id, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>("Unable to delete user.", HttpStatus.BAD_REQUEST);
        }
    }
}
