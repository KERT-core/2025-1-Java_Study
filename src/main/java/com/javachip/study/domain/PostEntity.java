// src/main/java/com/javachip/study/domain/PostEntity.java
package com.javachip.study.domain;

import java.time.LocalDateTime;

/**
 * DB와 매핑되는 도메인 객체 (불변)
 */
public class PostEntity {

    private final Long id;
    private final String title;
    private final String tag;
    private final String description;
    private final String content;
    private final UserEntity user;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public PostEntity(
            Long id,
            String title,
            String tag,
            String description,
            String content,
            UserEntity user,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.description = description;
        this.content = content;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getTag() { return tag; }
    public String getDescription() { return description; }
    public String getContent() { return content; }
    public UserEntity getUser() { return user; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
