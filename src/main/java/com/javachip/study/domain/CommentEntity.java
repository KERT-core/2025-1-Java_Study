package com.javachip.study.domain;

import java.time.LocalDateTime;

public class CommentEntity {

    private final Long id;
    private final String content;
    private final Long userId;
    private final LocalDateTime createdAt;
    private final PostEntity post;
    private final CommentEntity parent;
    public CommentEntity(
            Long id,
            String content,
            Long userId,
            PostEntity post,
            CommentEntity parent) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.post = post;
        this.parent = parent;
        this.createdAt = LocalDateTime.now();
    }
    public Long getId() {return id;}
    public String getContent() {return content;}
    public Long getUserId() {return userId;}
    public LocalDateTime getCreateTime() {return createdAt;}
    public PostEntity getPostEntity() {return post;}
    public CommentEntity getParent() {return parent;}
}
