package com.jaconda.usercrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND) //не выводит в консоль
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
