package com.javachip.study.controller;

import com.javachip.study.dto.BoardDto;
import com.javachip.study.response.ApiResponse;
import com.javachip.study.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<Long> create(@RequestBody BoardDto dto) {
        return ApiResponse.success(service.createBoard(dto));
    }

    @GetMapping("/{id}")
    public ApiResponse<BoardDto> getOne(@PathVariable Long id) {
        return ApiResponse.success(service.getBoard(id));
    }

    @GetMapping
    public ApiResponse<List<BoardDto>> list() {
        return ApiResponse.success(service.getAllBoards());
    }
}
