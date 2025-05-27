package com.javachip.study.dto;

public record SignupDto(
        Long studentId,
        String username,
        String password,
        String email
) {}
