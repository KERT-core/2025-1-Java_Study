package com.javachip.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventDateTimeParseException extends RuntimeException {
    public EventDateTimeParseException(String input) {
        super("날짜/시간을 파싱할 수 없습니다: " + input);
    }
}
