package com.jaconda.usercrud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateDTO {

    @Size(min = 2, max = 50, message = "Имя должно состоять из 2-ух до 50-ти символов")
    String name;
    @Email(message = "Некорректный формат email!")
    String email;
}