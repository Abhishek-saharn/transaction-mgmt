package com.n26.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GlobalTransactionException extends RuntimeException{
    public GlobalTransactionException(String message)
    {
        super(message);
    }
}
