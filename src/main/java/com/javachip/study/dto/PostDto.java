// src/main/java/com/javachip/study/dto/PostDto.java
package com.javachip.study.dto;

import java.time.LocalDateTime;

/**
 * API 레이어에서 주고받을 불변 데이터 구조
 */
public record PostDto(
        Long id,
        String title,
        String tag,
        String description,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
