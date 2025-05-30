package com.javachip.study.exception;
public class InvalidCredentialException extends RuntimeException {
    public InvalidCredentialException() {
        super("Invalid student ID or password");
    }
}
