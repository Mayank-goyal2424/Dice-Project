package com.dice.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WeatherServiceException.class)
    public ResponseEntity<WeatherServiceException> handleWeatherServiceException(WeatherServiceException ex) {
        return new ResponseEntity<>(new WeatherServiceException(ex.getMessage(), "WET-001",HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<WeatherServiceException> handleGlobalException(Exception ex) {
        return new ResponseEntity<>(new WeatherServiceException(ex.getMessage(), "WET-001",HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
