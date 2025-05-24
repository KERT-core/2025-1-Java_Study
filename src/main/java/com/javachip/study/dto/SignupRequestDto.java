package com.javachip.study.dto;

public record SignupRequestDto(
        Long studentId,
        String username,
        String password,
        String email
) {}
