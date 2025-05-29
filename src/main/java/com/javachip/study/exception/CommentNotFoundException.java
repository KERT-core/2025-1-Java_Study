package com.javachip.study.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(Long id) {
        super("comment not found with id " + id);
    }
}
