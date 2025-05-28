
package com.javachip.study.mapper;

import com.javachip.study.domain.BoardEntity;
import com.javachip.study.dto.BoardDto;

public interface BoardMapper {
    BoardEntity toEntity(BoardDto dto, Long id);
    BoardDto toDto(BoardEntity entity);
}