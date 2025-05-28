package com.javachip.study.dto;

public record UserDto(
        Long studentId,
        String username,
        String password,
        String email
) {}
