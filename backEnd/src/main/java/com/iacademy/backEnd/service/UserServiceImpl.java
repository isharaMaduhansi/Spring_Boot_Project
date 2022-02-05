package com.iacademy.backEnd.service;

import com.iacademy.backEnd.dto.UserDTO;
import com.iacademy.backEnd.entity.User;
import com.iacademy.backEnd.exception.IdNotFoundException;
import com.iacademy.backEnd.exception.UserNotFoundException;
import com.iacademy.backEnd.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<User> userList=userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }


    @Override
    public UserDTO getUserById(int  id){
              User user = userRepo.findById(id).orElseThrow(() -> new IdNotFoundException("Student not exist with id : " + id));
              return modelMapper.map(user , UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsersByName(String  name){
        List<User> userList = userRepo.findByName(name);
        if(userList.isEmpty()){
            throw new UserNotFoundException("User with this name not found");
        }
        return modelMapper.map(userList , new TypeToken<List<UserDTO>>(){}.getType());
    }

    @Override
    public List<UserDTO> getUsersOrderByName(){
        List<User> userList = userRepo.findAllByOrderByName();
        return modelMapper.map(userList , new TypeToken<List<UserDTO>>(){}.getType());
    }

    @Override
    public UserDTO updateUser(int id,UserDTO userDTO) {         // here

        User updatedUser = modelMapper.map(userDTO, User.class);
        User existUser = userRepo.findById(id).orElseThrow(() -> new IdNotFoundException("Student not exist with id : " + id));
        existUser.setName(updatedUser.getName());
        existUser.setAddress(updatedUser.getAddress());
        return modelMapper.map(userRepo.save(existUser) , UserDTO.class);
    }

    @Override
    public boolean deleteUser(int id) {

        User existUser = userRepo.findById(id).orElseThrow(() -> new IdNotFoundException("Student not exist with id : " + id));
        userRepo.delete(existUser);
        return true;
    }
}
