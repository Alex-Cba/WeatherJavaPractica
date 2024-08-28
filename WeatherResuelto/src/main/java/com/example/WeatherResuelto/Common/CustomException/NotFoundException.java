package com.example.WeatherResuelto.Common.CustomException;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
