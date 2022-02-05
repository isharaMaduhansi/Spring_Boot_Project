package com.iacademy.backEnd.service;

import com.iacademy.backEnd.dto.UserDTO;
import com.iacademy.backEnd.exception.IdNotFoundException;
import com.iacademy.backEnd.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    List<UserDTO> getUsersOrderByName();
    UserDTO getUserById(int id) throws IdNotFoundException;
    List<UserDTO> getAllUsersByName(String  name) throws UserNotFoundException;
    UserDTO updateUser(int id,UserDTO userDTO) throws IdNotFoundException;
    boolean deleteUser(int id) throws IdNotFoundException;
}
