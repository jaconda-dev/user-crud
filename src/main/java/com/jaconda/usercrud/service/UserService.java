package com.jaconda.usercrud.service;

import com.jaconda.usercrud.dto.UserDTO;
import com.jaconda.usercrud.dto.UserUpdateDTO;
import com.jaconda.usercrud.mapper.UserMapper;
import com.jaconda.usercrud.model.User;
import com.jaconda.usercrud.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

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

    public UserDTO create(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if(optionalUser.isPresent()){
            throw new IllegalStateException("Пользователь с данной почтой уже существует");
        }

        User user = userMapper.user(userDTO);

        user.setAge(Period.between(userDTO.getBirth(), LocalDate.now()).getYears());

        User userSaved = userRepository.save(user);

        return userMapper.userDTO(userSaved);
    }

    public void delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new IllegalStateException("Пользователя с данным id не существует");
        }
        userRepository.deleteById(id);
    }

   @Transactional
    public void update(Long id, UserUpdateDTO userUpdateDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new IllegalStateException("Пользователя с данным id: " + id + " не существует");
        }

        User user = optionalUser.get();

        if(userUpdateDTO.getEmail() != null && !userUpdateDTO.getEmail().equals(user.getEmail())){
            Optional<User> foundByEmail = userRepository.findByEmail(userUpdateDTO.getEmail());
            if (foundByEmail.isPresent()){
                throw new IllegalStateException("Данная почта занята другим пользователем!");
            }
            user.setEmail(userUpdateDTO.getEmail());
        }

        if (userUpdateDTO.getName() != null && !userUpdateDTO.getName().equals(user.getName())){
            user.setName(userUpdateDTO.getName());
        }

        //userRepository.save(user);
    }
}
