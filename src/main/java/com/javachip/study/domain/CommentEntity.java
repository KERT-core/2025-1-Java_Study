package com.javachip.study.domain;

import java.time.LocalDateTime;

public class CommentEntity {
    private final Long id;
    private final String content;
    private final Long userId;
    private final LocalDateTime createdAt;

    public CommentEntity(Long id, String content, Long userId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
    }
    public Long getId() {return id;}
    public String getContent() {return content;}
    public Long getUserId() {return userId;}
    public LocalDateTime getCreateTime() {return createdAt;}
}
