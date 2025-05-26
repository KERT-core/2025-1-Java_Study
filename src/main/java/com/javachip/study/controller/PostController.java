package com.javachip.study.controller;

import com.javachip.study.dto.PostDto;
import com.javachip.study.service.PostService;

import java.util.List;

public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public PostDto createPost(PostDto dto) {
        return postService.create(dto);
    }

    public List<PostDto> listPosts(String search) {
        return postService.getAll(search);
    }

    public PostDto getPost(Long id) {
        return postService.getById(id);
    }

    public PostDto updatePost(Long id, PostDto dto) {
        return postService.update(id, dto);
    }

    public void deletePost(Long id) {
        postService.delete(id);
    }
}
