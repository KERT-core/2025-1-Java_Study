package com.javachip.study.mapper;

import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.UserDto;

//UserEntity <-> UserDto 간의 변환을 담당하는 매퍼 인터페이스
//직접 구현체 클래스를 만들거나 MapStruct를 활용 가능

public interface UserMapper {
    UserEntity toEntity(UserDto dto);
    UserDto toDto(UserEntity entity);
}
