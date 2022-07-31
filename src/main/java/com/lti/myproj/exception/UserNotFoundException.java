package com.lti.myproj.exception;

public class UserNotFoundException extends RuntimeException {
    public String message = "No such user with id";
}