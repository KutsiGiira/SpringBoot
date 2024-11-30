package com.example.rest.restCnt;

public class ExceptionFound extends RuntimeException{

    public ExceptionFound(String message) {
        super(message);
    }

    public ExceptionFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionFound(Throwable cause) {
        super(cause);
    }
}
