package com.javachip.study.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(
        @NotNull(message = "학번은 필수입니다")
        Long studentId,

        @NotBlank(message = "이름은 필수입니다")
        String username,

        @Size(min = 4, message = "비밀번호는 최소 4자리 이상입니다")
        String password,

        @Email(message = "유효한 이메일 형식이여야 합니다")
        String email
) {}
