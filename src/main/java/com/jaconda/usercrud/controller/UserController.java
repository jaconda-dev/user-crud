package com.jaconda.usercrud.controller;

import com.jaconda.usercrud.dto.UserDTO;
import com.jaconda.usercrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDTO> read(UserDTO userDTO){
        return userService.read(userDTO);
    }
}
