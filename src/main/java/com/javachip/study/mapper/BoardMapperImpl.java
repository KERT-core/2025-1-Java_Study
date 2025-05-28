package com.javachip.study.mapper;

import com.javachip.study.domain.BoardEntity;
import com.javachip.study.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BoardMapperImpl implements BoardMapper {
    @Override
    public BoardEntity toEntity(BoardDto dto, Long id) {
        return new BoardEntity(
                id,
                dto.title(),
                dto.content(),
                dto.author(),
                LocalDateTime.now()
        );
    }

    @Override
    public BoardDto toDto(BoardEntity e) {
        return new BoardDto(
                e.getId(),
                e.getTitle(),
                e.getContent(),
                e.getAuthor(),
                e.getCreatedAt()
        );
    }
}
