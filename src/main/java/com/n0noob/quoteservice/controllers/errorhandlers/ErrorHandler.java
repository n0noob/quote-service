package com.n0noob.quoteservice.controllers.errorhandlers;

import com.n0noob.quoteservice.models.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<Error> handleException(NoSuchElementException e) {
        log.warn(e.getMessage());
        return new ResponseEntity<>(new Error(e.getMessage(), "404"), HttpStatus.NOT_FOUND);
    }

}
