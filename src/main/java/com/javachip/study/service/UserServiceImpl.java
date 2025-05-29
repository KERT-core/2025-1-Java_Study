package com.javachip.study.service;

import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.UserDto;
import com.javachip.study.repository.UserRepository;
import com.javachip.study.mapper.UserMapper;
import com.javachip.study.exception.UserNotFoundException;

import java.util.*;

//UserService 인터페이스의 구현체
//생성자 주입 사용

public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final UserMapper mapper;
    
    public UserServiceImpl(UserRepository repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Long signup(UserDto dto) {
        if (repo.findByStudentId(dto.studentId()) != null) {
            throw new IllegalArgumentException("이미 존재하는 학번입니다");
        }

        UserEntity user = mapper.toEntity(dto);
        repo.save(user);
        return user.getStudentId();
    }

    @Override
    public UserDto getUser(Long studentId) {
        UserEntity user = repo.findByStudentId(studentId);
        if (user == null) {
            throw new UserNotFoundException(studentId);
        }
        return mapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }
}
