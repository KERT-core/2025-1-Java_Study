package com.javachip.study.repository;

import com.javachip.study.domain.BoardEntity;

import java.util.List;

public interface BoardRepository {
    void save(BoardEntity board);
    BoardEntity findById(Long id);      // 없으면 null 반환
    List<BoardEntity> findAll();
}
