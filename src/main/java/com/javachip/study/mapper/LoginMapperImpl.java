package com.javachip.study.mapper;

import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.LoginDto;

public class LoginMapperImpl implements LoginMapper{
    @Override
    public UserEntity toEntity(LoginDto dto) {
        return new UserEntity(
                dto.studentId(),
                null,
                dto.password(),
                null
        );
    }

    @Override
    public LoginDto toDto(UserEntity entity) {
        return new LoginDto(
                entity.getStudentId(),
                entity.getPassword()
        );
    }
}
