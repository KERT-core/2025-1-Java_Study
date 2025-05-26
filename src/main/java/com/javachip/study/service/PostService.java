package com.javachip.study.service;

import com.javachip.study.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto create(PostDto dto);
    List<PostDto> getAll(String search);
    PostDto getById(Long id);
    PostDto update(Long id, PostDto dto);
    void delete(Long id);
}
