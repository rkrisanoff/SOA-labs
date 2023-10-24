package com.example.additional.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnrealMeaningException extends IllegalArgumentException {
    public UnrealMeaningException(String msg) {
        super("Значение: " + msg + " не соответствет ожидаемому числу");
    }
}