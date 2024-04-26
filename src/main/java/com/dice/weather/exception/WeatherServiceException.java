package com.dice.weather.exception;

import org.springframework.http.HttpStatus;

public class WeatherServiceException extends Exception{

    String message;
    String code;
    HttpStatus httpStatus;

    public WeatherServiceException(String message, String code, HttpStatus httpStatus) {
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
