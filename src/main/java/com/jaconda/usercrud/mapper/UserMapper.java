package com.jaconda.usercrud.mapper;

import com.jaconda.usercrud.dto.UserDTO;
import com.jaconda.usercrud.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.http.ResponseEntity;

import java.util.List;

//componentModel = "spring" - можно так
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDTO userDTO(User user);

    User user(UserDTO userDTO);

    List<UserDTO> listUsers(List<User> users);
}
