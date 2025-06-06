package com.javachip.study.controller;

import com.javachip.study.service.UserService;
import com.javachip.study.dto.UserDto;
import com.javachip.study.response.ApiResponse;
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

    @PostMapping
    public ApiResponse<Long> create(@RequestBody UserDto dto) {
        return ApiResponse.success(service.register(dto));
    }

    @GetMapping("/{id}")
    public ApiResponse<UserDto> get(@PathVariable Long id) {
        return ApiResponse.success(service.getUser(id));
    }

    @GetMapping
    public ApiResponse<List<UserDto>> list() {
        return ApiResponse.success(service.getAllUsers());
    }
}
