package com.javachip.study.repository;

import com.javachip.study.domain.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    CommentEntity save(CommentEntity commentEntity);
    List<CommentEntity> findAll();
    Optional<CommentEntity> findById(Long id);
    List<CommentEntity> findByPostId(Long postId);
    List<CommentEntity> findByParentId(Long parentId);
    void deleteById(Long id);
}
