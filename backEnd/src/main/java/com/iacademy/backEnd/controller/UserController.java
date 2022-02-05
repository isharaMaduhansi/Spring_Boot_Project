package com.iacademy.backEnd.controller;


import com.iacademy.backEnd.dto.UserDTO;
import com.iacademy.backEnd.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "api/user")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserDTO>> getUsers() {

        return new ResponseEntity<>(userServiceImpl.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/getUsersOrderByName")
    public ResponseEntity<List<UserDTO>> getUsersOrderByName() {

        return new ResponseEntity<>(userServiceImpl.getUsersOrderByName(), HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {

        return new ResponseEntity<>(userServiceImpl.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/getUsersByName/{name}")
    public ResponseEntity<List<UserDTO>> getUsersByName(@PathVariable String name) {

        return new ResponseEntity<>(userServiceImpl.getAllUsersByName(name), HttpStatus.OK);
    }


    @PostMapping("/saveUser")
    public ResponseEntity<Boolean> saveUser(@RequestBody UserDTO userDTO) {

        userServiceImpl.saveUser(userDTO);
        return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
    }

    @PostMapping("/updateUser/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable int id ,@RequestBody UserDTO userDTO) {

         userServiceImpl.updateUser(id,userDTO);
        return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
    }

    @GetMapping("/deleteUser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id) {

         userServiceImpl.deleteUser(id);
        return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
    }

}
