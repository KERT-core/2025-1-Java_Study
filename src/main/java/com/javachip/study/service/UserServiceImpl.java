package com.javachip.study.service;

import com.javachip.study.config.JwtUtil;
import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.LoginRequestDto;
import com.javachip.study.dto.UserDto;
import com.javachip.study.exception.InvalidCredentialException;
import com.javachip.study.repository.UserRepository;
import com.javachip.study.mapper.UserMapper;
import com.javachip.study.exception.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

//UserService 인터페이스의 구현체
//생성자 주입 사용

public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    public UserServiceImpl(UserRepository repo,
                           UserMapper mapper,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.repo = repo;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Long signup(UserDto dto) {
        if (repo.findByStudentId(dto.studentId()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 학번입니다");
        }
      
        String encodedPwd = passwordEncoder.encode(dto.password());
        UserEntity user = new UserEntity(
                dto.studentId(),
                dto.username(),
                encodedPwd,
                dto.email()
        );

        repo.save(user);
        return user.getStudentId();
    }

    @Override
    public String login(LoginRequestDto dto) {
        // studentId 로 조회
        UserEntity user = repo.findByStudentId(dto.studentId())
                .orElseThrow(()-> new UserNotFoundException(dto.studentId()));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new InvalidCredentialException();
        }
        return jwtUtil.generateToken(String.valueOf(user.getStudentId()));
    }

    @Override
    public UserDto getUser(Long studentId) {
        UserEntity user = repo.findByStudentId(studentId)
                .orElseThrow(() -> new UserNotFoundException(studentId));
        return mapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }
}
