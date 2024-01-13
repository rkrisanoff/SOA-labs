package com.example.demows.exception;


import com.example.demows.DTO.ErrorDTO;

public class ServerNotAvailable extends RuntimeException {
    ErrorDTO errorDTO;
    public ServerNotAvailable() {
        super("asd");
    }
    public ServerNotAvailable(ErrorDTO errorDTO) {
        this.errorDTO=errorDTO;
    }

}
