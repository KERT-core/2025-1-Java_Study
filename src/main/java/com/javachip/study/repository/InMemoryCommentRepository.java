package com.javachip.study.repository;

import com.javachip.study.domain.CommentEntity;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


public class InMemoryCommentRepository implements CommentRepository {

    private final Map<Long, CommentEntity> store = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);
    @Override
    public CommentEntity save(CommentEntity comment) {
        if(comment.getId() == null){
            Long newId = sequence.incrementAndGet();
            CommentEntity saved = new CommentEntity(
                    newId,
                    comment.getContent(),
                    comment.getUser(),
                    comment.getPostEntity(),
                    comment.getParent(),
                    comment.getCreateTime()
            );
            store.put(newId, saved);
            return saved;
        }else{
            store.put(comment.getId(), comment);
            return comment;
        }
    }
    @Override
    public Optional<CommentEntity> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<CommentEntity> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public List<CommentEntity> findByPostId(Long postId) {
        return store.values().stream()
                .filter(comment -> comment.getPostEntity().getId().equals(postId))
                .collect(Collectors.toList());
    }
    @Override
    public List<CommentEntity> findByParentId(Long parentId) {
        return store.values().stream()
                .filter(comment -> comment.getParent().getId().equals(parentId))
                .collect(Collectors.toList());
    }
    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
