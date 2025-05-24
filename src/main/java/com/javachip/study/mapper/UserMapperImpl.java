package com.javachip.study.mapper;

import com.javachip.study.domain.User;
import com.javachip.study.dto.UserDto;

//UserMapper 인터페이스의 구현체
//UserEntity <-> UserDto 변환 로직

//public class UserMapperImpl implements UserMapper {
//    @Override
//    public User toEntity(UserDto dto, Long id) {
//        return new User(id, dto.username(), dto.age());
//    }
//
//    @Override
//    public UserDto toDto(User entity) {
//        return new UserDto(entity.getId(), entity.getUsername(), entity.getAge());
//    }
//}
