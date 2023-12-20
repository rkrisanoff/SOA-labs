package com.example.additional.controller;

import com.example.additional.DTO.ErrorDTO;
import com.example.additional.exception.ServerNotAvailable;
import com.example.additional.exception.UnrealMeaningException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ServerNotAvailable.class)
    public ResponseEntity<ErrorDTO> handlerServerNotAvailable(ServerNotAvailable exception) {
        return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body(new ErrorDTO("Сервер недоступен"));
    }
    @ExceptionHandler(UnrealMeaningException.class)
    public ResponseEntity<String> handleEntityNotFoundException(UnrealMeaningException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> allException(ServerNotAvailable exception) {
        return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body(new ErrorDTO("Сервер недоступен"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        response.put("errors", errors);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response.toString());
    }



}
