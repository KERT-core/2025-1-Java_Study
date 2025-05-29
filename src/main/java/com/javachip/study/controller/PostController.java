package com.javachip.study.controller;

import com.javachip.study.dto.PostDto;
import com.javachip.study.response.ApiResponse;
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
    public ResponseEntity<ApiResponse<PostDto>> createPost(@RequestBody PostDto dto) {
        PostDto result = postService.create(dto);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostDto>>> listPosts(@RequestParam(required = false) String search) {
        List<PostDto> result = postService.getAll(search);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostDto>> getPost(@PathVariable Long id) {
        try{
            PostDto result = postService.getById(id);
            return ResponseEntity.ok(ApiResponse.success(result));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.fail(e, 404));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostDto>> updatePost(@PathVariable Long id, @RequestBody PostDto dto) {
        try{
            PostDto result = postService.update(id, dto);
            return ResponseEntity.ok(ApiResponse.success(result));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.fail(e, 404));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ApiResponse.success(null));
    }
}
