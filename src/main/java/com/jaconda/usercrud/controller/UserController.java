package com.jaconda.usercrud.controller;

import com.jaconda.usercrud.dto.UserDTO;
import com.jaconda.usercrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/users")
    public UserDTO create(@RequestBody UserDTO userDTO){
        return userService.create(userDTO);
    }
}
