// src/main/java/com/javachip/study/service/BoardService.java
package com.javachip.study.service;

import com.javachip.study.domain.BoardEntity;
import com.javachip.study.dto.BoardDto;
import com.javachip.study.exception.BoardNotFoundException;
import com.javachip.study.mapper.BoardMapper;
import com.javachip.study.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private final BoardRepository repo;
    private final BoardMapper mapper;
    private final AtomicLong seq = new AtomicLong(0);

    public BoardService(@Qualifier("boardRepository") BoardRepository repo, @Qualifier("boardMapper") BoardMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Long createBoard(BoardDto dto) {
        Long id = seq.incrementAndGet();
        repo.save(mapper.toEntity(dto, id));
        return id;
    }

    public BoardDto getBoard(Long id) {
        BoardEntity e = repo.findById(id);
        if (e == null) throw new BoardNotFoundException(id);
        return mapper.toDto(e);
    }

    public List<BoardDto> getAllBoards() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
