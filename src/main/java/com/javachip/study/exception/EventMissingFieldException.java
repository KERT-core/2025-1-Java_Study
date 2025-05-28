package com.javachip.study.exception;

public class EventMissingFieldException extends RuntimeException {
    public EventMissingFieldException(String message) {
        super("필수 입력값이 누락되었습니다: " + message);
    }
}
