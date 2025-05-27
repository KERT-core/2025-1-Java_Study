package com.javachip.study.mapper;

import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.LoginDto;

public interface LoginMapper {
    UserEntity toEntity(LoginDto dto);
    LoginDto toDto(UserEntity entity);
}
