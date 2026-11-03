package com.example.library.exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}