package com.javachip.study.exception;

import java.time.LocalDateTime;

public class EventInvalidTimeRangeException extends RuntimeException {
    public EventInvalidTimeRangeException(LocalDateTime start, LocalDateTime end) {
        super("시작 시간(" + start + ")이 종료 시간(" + end + ")보다 늦습니다.");
    }
}
