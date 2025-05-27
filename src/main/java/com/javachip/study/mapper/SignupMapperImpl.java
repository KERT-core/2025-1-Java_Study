package com.javachip.study.mapper;

import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.UserDto;

//UserMapper 인터페이스의 구현체
//UserEntity <-> UserDto 변환 로직

public class SignupMapperImpl implements SignupMapper {
    @Override
    public UserEntity toEntity(UserDto dto) {
        return new UserEntity(
                dto.studentId(),
                dto.username(),
                dto.password(),
                dto.email()
        );
    }

    @Override
    public UserDto toDto(UserEntity entity) {
        return new UserDto(
                entity.getStudentId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getEmail()
        );
    }
}
