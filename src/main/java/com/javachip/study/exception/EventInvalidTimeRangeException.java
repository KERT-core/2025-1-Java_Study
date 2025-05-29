package com.javachip.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventInvalidTimeRangeException extends RuntimeException {
    public EventInvalidTimeRangeException(LocalDateTime start, LocalDateTime end) {
        super("시작 시간(" + start + ")이 종료 시간(" + end + ")보다 늦습니다.");
    }
}
