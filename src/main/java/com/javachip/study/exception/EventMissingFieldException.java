package com.javachip.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventMissingFieldException extends RuntimeException {
    public EventMissingFieldException(String message) {
        super("필수 입력값이 누락되었습니다: " + message);
    }
}
