// src/main/java/com/javachip/study/repository/InMemoryPostRepository.java
package com.javachip.study.repository;

import com.javachip.study.domain.PostEntity;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * 메모리 기반 PostRepository 구현체
 */
public class InMemoryPostRepository implements PostRepository {

    private final Map<Long, PostEntity> store = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public PostEntity save(PostEntity post) {
        if (post.getId() == null) {
            Long newId = sequence.incrementAndGet();
            PostEntity saved = new PostEntity(
                    newId,
                    post.getTitle(),
                    post.getTag(),
                    post.getDescription(),
                    post.getContent(),
                    post.getUser(),
                    post.getCreatedAt(),
                    post.getUpdatedAt()
            );
            store.put(newId, saved);
            return saved;
        } else {
            store.put(post.getId(), post);
            return post;
        }
    }

    @Override
    public Optional<PostEntity> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<PostEntity> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public List<PostEntity> findByTitleContainingOrTagContaining(String title, String tag) {
        return store.values().stream()
                .filter(p -> p.getTitle().contains(title) || p.getTag().contains(tag))
                .collect(Collectors.toList());
    }
}
