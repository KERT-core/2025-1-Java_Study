package com.javachip.study.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("해당 ID(" + id + ")에 대한 이벤트를 찾을 수 없습니다.");
    }
}
