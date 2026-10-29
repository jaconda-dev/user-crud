package com.jaconda.usercrud.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    Long id;

    @NotBlank(message = "Имя не может быть пустым!")
    @Size(min = 2, max = 50, message = "Имя должно состоять из 2-ух до 50-ти символов!")
    String name;

    @NotBlank(message = "Email не может быть пустым!!")
    @Email(message = "Некорректный формат email")
    String email;

    @NotNull(message = "Дата рождения не может быть пустым значением!")
    @Past(message = "Некорректная дата рождения!")
    LocalDate birth;

    Integer age;
}
