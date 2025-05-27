package com.javachip.study.service;

import com.javachip.study.dto.CommentDto;
import java.util.List;

public interface CommentService {
    CommentDto create(CommentDto commentDto);
    List<CommentDto> getAll();
    CommentDto getById(Long id);
    //CommentDto update(Long id, CommentDto commentDto);
    void delete(Long id);
}
