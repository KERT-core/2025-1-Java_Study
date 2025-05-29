package com.javachip.study.domain;

import java.time.LocalDateTime;

public class CommentEntity {

    private final Long id;
    private final String content;
    private final UserEntity user;
    private final LocalDateTime createdAt;
    private final PostEntity post;
    private final CommentEntity parent;
    public CommentEntity(
            Long id,
            String content,
            UserEntity user,
            PostEntity post,
            CommentEntity parent,
            LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.post = post;
        this.parent = parent;
        this.createdAt = LocalDateTime.now();
    }
    public Long getId() {return id;}
    public String getContent() {return content;}
    public UserEntity getUser() {return user;}
    public LocalDateTime getCreateTime() {return createdAt;}
    public PostEntity getPostEntity() {return post;}
    public CommentEntity getParent() {return parent;}
}
