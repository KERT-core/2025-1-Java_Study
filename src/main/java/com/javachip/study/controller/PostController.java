package com.javachip.study.controller;

import com.javachip.study.dto.PostDto;
import com.javachip.study.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto dto) {
        PostDto result = postService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> listPosts(@RequestParam(required = false) String search) {
        List<PostDto> result = postService.getAll(search);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        PostDto result = postService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto dto) {
        PostDto result = postService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
