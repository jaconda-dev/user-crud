package com.jaconda.usercrud.controller;

import com.jaconda.usercrud.dto.UserDTO;
import com.jaconda.usercrud.dto.UserUpdateDTO;
import com.jaconda.usercrud.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDTO> read(){
        return userService.read();
    }

    @PostMapping("/users")
    public UserDTO create(@Valid @RequestBody UserDTO userDTO){
        return userService.create(userDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable
            @Min(value = 1, message = "ID должен быть больше 0")
            Long id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable(name = "id")
            @Min(value = 1, message = "ID должен быть больше 0")
            Long id,
            @Valid @RequestBody UserUpdateDTO userUpdateDTO){
        userService.update(id, userUpdateDTO);
    }
}
