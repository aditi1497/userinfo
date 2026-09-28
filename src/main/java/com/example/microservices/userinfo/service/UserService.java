package com.example.microservices.userinfo.service;


import com.example.microservices.userinfo.dto.UserDTO;
import com.example.microservices.userinfo.entity.User;
import com.example.microservices.userinfo.mapper.UserMapper;
import com.example.microservices.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


   public  UserDTO addUser(UserDTO userDTO)
   {
       User savedUser=userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
       return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
   }

   public ResponseEntity<UserDTO> fetchDetailsById(Integer userId)
   {
       Optional<User> fetchedUser=userRepo.findById(userId);
       System.out.println("entering***1"+userId);
       if(fetchedUser.isPresent())
       {
           System.out.println("entering**2"+userId);
           return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
       }
       System.out.println("entering**"+userId);
     return new ResponseEntity<>(new UserDTO(),HttpStatus.NOT_FOUND);

   }
}
