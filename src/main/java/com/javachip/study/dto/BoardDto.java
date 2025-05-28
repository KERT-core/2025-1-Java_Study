package com.javachip.study.dto;

import java.time.LocalDateTime;


public record BoardDto(
        Long id,
        String title,
        String content,
        String author,
        LocalDateTime createdAt
) {}