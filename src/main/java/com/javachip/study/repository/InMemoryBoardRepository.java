// src/main/java/com/javachip/study/repository/InMemoryBoardRepository.java
package com.javachip.study.repository;

import com.javachip.study.domain.BoardEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryBoardRepository implements BoardRepository {
    private final Map<Long, BoardEntity> store = new HashMap<>();

    @Override
    public void save(BoardEntity board) {
        store.put(board.getId(), board);
    }

    @Override
    public BoardEntity findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<BoardEntity> findAll() {
        return new ArrayList<>(store.values());
    }
}
