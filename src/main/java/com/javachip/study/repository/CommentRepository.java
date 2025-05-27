package com.javachip.study.repository;

import com.javachip.study.domain.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    CommentEntity save(CommentEntity commentEntity);
    List<CommentEntity> findAll();
    Optional<CommentEntity> findById(Long id);
    List<CommentEntity> findByUserIdAndCommentId(Long userId, Long commentId);
    List<CommentEntity> findByPostId(Long postId);
    void deleteById(Long id);
}
