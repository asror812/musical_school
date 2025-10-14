package com.example.school.exception;

public class TooManyRequestsException  extends RuntimeException{

    public TooManyRequestsException(String message) {
        super(message);
    }

}
