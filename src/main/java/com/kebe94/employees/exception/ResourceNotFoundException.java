package com.kebe94.employees.exception;

import ch.qos.logback.core.spi.ErrorCodes;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private HttpStatus status;
    private String message;



    public ResourceNotFoundException(String message) {
        super(message);
    }



    public HttpStatus getStatus() {
        return status;
    }

}