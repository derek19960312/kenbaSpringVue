package com.kenba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnProcessableException extends RuntimeException {

    public UnProcessableException() {
        super();
    }

    public UnProcessableException(String message) {
        super(message);
    }

}