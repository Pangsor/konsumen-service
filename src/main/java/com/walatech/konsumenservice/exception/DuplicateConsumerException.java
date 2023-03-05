package com.walatech.konsumenservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicateConsumerException extends RuntimeException{

    private String message;

    public DuplicateConsumerException(String message){
        super(message);
    }
}
