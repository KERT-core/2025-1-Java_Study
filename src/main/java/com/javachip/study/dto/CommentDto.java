package com.javachip.study.dto;

import java.time.LocalDateTime;

public record CommentDto(
        Long id,
        Long userId,
        Long postId,
        Long parentId,
        String content,
        LocalDateTime createdAt
) {}