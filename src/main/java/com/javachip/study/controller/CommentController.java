package com.javachip.study.controller;

import com.javachip.study.dto.CommentDto;
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
    public CommentDto createComment(@PathVariable Long postId, @RequestBody CommentDto dto) {
        return commentService.create(dto);
    }
    @GetMapping
    public List<CommentDto> listComments(@PathVariable Long postId) {
        return commentService.getAll();
    }
    @GetMapping("/{id}")
    public CommentDto getCommentById(@PathVariable Long postId, @PathVariable Long id) {
        return commentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}
