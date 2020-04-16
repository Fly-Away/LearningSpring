package com.api.b2b.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistException extends RuntimeException {

    public ResourceAlreadyExistException(String message){
        super(message);
    }
}