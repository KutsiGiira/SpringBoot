package com.example.rest.restCnt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    @ExceptionHandler
    public ResponseEntity<Error> handler(ExceptionFound exc){
        Error r = new Error();
        r.setMessage(exc.getMessage());
        r.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<Error> hanlder(Exception exc){
        Error d = new Error();
        d.setStatus(HttpStatus.BAD_REQUEST.value());
        d.setMessage(exc.getMessage());
        return new ResponseEntity<>(d, HttpStatus.BAD_REQUEST);
    }
}
