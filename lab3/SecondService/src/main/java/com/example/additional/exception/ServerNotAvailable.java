package com.example.additional.exception;


import com.example.additional.DTO.ErrorDTO;

public class ServerNotAvailable extends RuntimeException {
    ErrorDTO errorDTO;
    public ServerNotAvailable() {
        super("asd");
    }
    public ServerNotAvailable(ErrorDTO errorDTO) {
        this.errorDTO=errorDTO;
    }

}
