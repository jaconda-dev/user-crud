package com.jaconda.usercrud.service;

import com.jaconda.usercrud.dto.UserDTO;
import com.jaconda.usercrud.mapper.UserMapper;
import com.jaconda.usercrud.model.User;
import com.jaconda.usercrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> read(UserDTO userDTO){
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            throw new RuntimeException("Список пользователей пуст");
        }
        return userMapper.listUsers(users);
    }
}
