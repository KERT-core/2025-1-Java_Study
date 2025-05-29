// src/main/java/com/javachip/study/repository/PostRepository.java
package com.javachip.study.repository;

import com.javachip.study.domain.PostEntity;

import java.util.List;
import java.util.Optional;

/**
 * Post 전용 저장소 인터페이스
 */
public interface PostRepository {
    PostEntity save(PostEntity post);
    Optional<PostEntity> findById(Long id);
    List<PostEntity> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
    List<PostEntity> findByTitleContainingOrTagContaining(String title, String tag);
}
