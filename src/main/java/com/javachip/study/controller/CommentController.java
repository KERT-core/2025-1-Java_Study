package com.javachip.study.controller;

import com.javachip.study.dto.CommentDto;
import com.javachip.study.response.ApiResponse;
import com.javachip.study.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ApiResponse<CommentDto> createComment(@PathVariable Long postId, @RequestBody CommentDto dto) {
        CommentDto result = commentService.create(dto);
        return ApiResponse.success(result);
    }

    @GetMapping
    public ApiResponse<List<CommentDto>> listComments(@PathVariable Long postId) {
        List<CommentDto> result = commentService.getAllByPostId(postId);
        return ApiResponse.success(result);
    }
    @GetMapping("/{id}")
    public ApiResponse<CommentDto> getCommentById(@PathVariable Long postId, @PathVariable Long id) {
        return ApiResponse.success(commentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long postId, @PathVariable Long id) {
        commentService.delete(id);
    }
}
