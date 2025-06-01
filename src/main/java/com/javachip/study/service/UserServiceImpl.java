package com.javachip.study.service;

import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.UserDto;
import com.javachip.study.repository.UserRepository;
import com.javachip.study.mapper.UserMapper;

import java.util.*;
import java.util.stream.Collectors;

//UserService 인터페이스의 구현체
//생성자 주입 사용

public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final UserMapper userMapper;
    
    public UserServiceImpl(UserRepository userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public void addUsers(List<UserDto> userDtoList){
        List<UserEntity> userEntities = userDtoList.stream()
                .map(userMapper::toEntity)
                .collect(Collectors.toList());

        userRepo.saveAll(userEntities);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(userMapper::toDto).toList();
    }
}
