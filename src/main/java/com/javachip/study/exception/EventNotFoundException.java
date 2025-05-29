package com.javachip.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("해당 ID(" + id + ")에 대한 이벤트를 찾을 수 없습니다.");
    }
}
