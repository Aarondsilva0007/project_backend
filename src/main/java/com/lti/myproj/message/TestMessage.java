package com.lti.myproj.message;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

public class TestMessage extends ResponseEntity<String> {

    public TestMessage() {
        super("lemon", HttpStatus.ACCEPTED);
    }
}