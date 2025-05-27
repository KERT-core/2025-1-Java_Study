package com.javachip.study.controller;

import com.javachip.study.dto.CommentDto;
import com.javachip.study.service.CommentService;

import java.util.List;

public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) { this.commentService = commentService; }
    public CommentDto createComment(CommentDto dto) { return commentService.create(dto);}
    public List<CommentDto> listComments() { return commentService.getAll();}
    public CommentDto getCommentById(Long id) { return commentService.getById(id);}
    public void delete(Long id) { commentService.delete(id);}
}
