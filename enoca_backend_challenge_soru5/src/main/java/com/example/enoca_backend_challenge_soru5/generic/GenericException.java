package com.example.enoca_backend_challenge_soru5.generic;

import com.example.enoca_backend_challenge_soru5.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class GenericException extends ResponseEntityExceptionHandler {
    @ExceptionHandler({
            CustomerCreationException.class,
            CustomerDatebaseException.class,
            CustomerNotFoundException.class,
            OrderCreationException.class,
            OrderDatabaseException.class,
            OrderNotFoundException.class
    })
    public ResponseEntity<Object> handleCustomException(Exception e) {
        GenericExceptionResponse error = new GenericExceptionResponse(e.getMessage(), new Date());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }


}
