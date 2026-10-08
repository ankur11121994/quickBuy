package com.ecommerce.quickBuy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        // Log the exception or perform any other necessary actions
        return "An error occurred: " + ex.getMessage();
    }
}
