package com.javachip.study.controller;

import com.javachip.study.service.UserService;
import com.javachip.study.dto.UserDto;
import com.javachip.study.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//사용자 관련 API 요청을 처리하는 컨트롤러 클래스
//사용자 등록, 조회를 지원

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // 회원가입
    @PostMapping("/signup")
    public ApiResponse<Long> create(@RequestBody UserDto dto) {
        try {
            return ApiResponse.success(service.signup(dto));
        } catch (IllegalArgumentException e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    // 사용자 조회
    @GetMapping("/{studentId}")
    public ApiResponse<UserDto> get(@PathVariable Long studentId) {
        try {
            return ApiResponse.success(service.getUser(studentId));
        } catch (IllegalArgumentException e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    // 전체 사용자 조회
    @GetMapping
    public ApiResponse<List<UserDto>> list() {
        try {
            return ApiResponse.success(service.getAllUsers());
        } catch (IllegalArgumentException e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

}
