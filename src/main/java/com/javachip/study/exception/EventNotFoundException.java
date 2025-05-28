package com.javachip.study.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("Event with ID [" + id + "] not found.");
    }
}
