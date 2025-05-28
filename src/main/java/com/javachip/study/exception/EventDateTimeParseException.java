package com.javachip.study.exception;

public class EventDateTimeParseException extends RuntimeException {
    public EventDateTimeParseException(String input) {
        super("날짜/시간을 파싱할 수 없습니다: " + input);
    }
}
