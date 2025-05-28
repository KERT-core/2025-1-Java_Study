package com.javachip.study.controller;

import com.javachip.study.dto.CommentDto;
import com.javachip.study.response.ApiResponse;
import com.javachip.study.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<CommentDto>> createComment(@PathVariable Long postId, @RequestBody CommentDto dto) {
        CommentDto result = commentService.create(dto);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CommentDto>>> listComments(@PathVariable Long postId) {
        List<CommentDto> result = commentService.getAllByPostId(postId);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CommentDto>> getCommentById(@PathVariable Long postId, @PathVariable Long id) {
        try{
            CommentDto result = commentService.getById(id);
            return ResponseEntity.ok(ApiResponse.success(result));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.fail(e, 404));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long postId, @PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ApiResponse.success(null));
    }
}
