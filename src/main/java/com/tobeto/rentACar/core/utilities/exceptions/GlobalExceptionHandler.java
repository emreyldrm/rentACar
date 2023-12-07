package com.tobeto.rentACar.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException exception){
        String errorMessages = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " +fieldError.getDefaultMessage())
                .collect(Collectors.joining("\", \""));
        ErrorResponse errorResponse = new ErrorResponse(errorMessages);
        return ResponseEntity.badRequest().body(errorResponse);
    }

//    public String handleValidationError(MethodArgumentNotValidException exception){
//        return "Validasyon Hatası";
//    }


    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException exception){
        return exception.getMessage();
    }

}
