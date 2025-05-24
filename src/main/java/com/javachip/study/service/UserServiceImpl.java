package com.javachip.study.service;

import com.javachip.study.domain.User;
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
    public Long register(UserDto dto) {
        Long newId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        User user = mapper.toEntity(dto, newId);
        repo.save(user);
        return newId;
    }

    @Override
    public UserDto getUser(Long id) {
        return Optional.ofNullable(repo.findById(id))
            .map(mapper::toDto)
            .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }
}
