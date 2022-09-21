package com.motive.groupexercise.domain.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.HashMap;


/**
 * Standard handler for custom exceptions.
 */
@Slf4j
@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handler fpr unexpected errors that could occur during set and get operations for the messages.
     *
     * @param e - exception thrown if anything unexpected occurs
     * @param request - Standard request
     * @return ResponseEntity - appropriate response
     */
    @ExceptionHandler(ProductException.class)
    private ResponseEntity<Object> handle(ProductException e, WebRequest request) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", HttpStatus.INTERNAL_SERVER_ERROR.name());
        body.put("message", e.getMessage());
        log.error("Something went wrong persisting or retrieving the message", e, request);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * Handler fpr messages that are not found.
     *
     * @param e - exception thrown if
     * @param request - Standard request
     * @return ResponseEntity - appropriate response
     */
    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<Object> handle(ProductNotFoundException e, WebRequest request) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.name());
        body.put("message", e.getMessage());
        log.error("No product found for request", e, request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
