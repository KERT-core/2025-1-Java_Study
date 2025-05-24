package com.javachip.study.exception;

//특정 User를 찾았을 때 Null이면 반환하는 예외

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User not found: " + id);
    }
}
