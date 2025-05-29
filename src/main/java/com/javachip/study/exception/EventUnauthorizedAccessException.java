package com.javachip.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EventUnauthorizedAccessException extends RuntimeException {
    public EventUnauthorizedAccessException(Long id) {
        super("해당 ID(" + id + ")에 대한 접근 권한이 없습니다.");
    }
}
