package com.example.microservices.userinfo.mapper;

import com.example.microservices.userinfo.dto.UserDTO;
import com.example.microservices.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper  INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User restaurant);
}
