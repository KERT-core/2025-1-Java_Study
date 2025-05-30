package com.javachip.study.dto;

public record LoginRequestDto(
        Long studentId,
        String password
) {}