// src/main/java/com/javachip/study/mapper/PostMapperImpl.java
package com.javachip.study.mapper;

import com.javachip.study.domain.PostEntity;
import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.PostDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostEntity toEntity(PostDto dto, UserEntity user) {
        return new PostEntity(
                null,                    // id는 저장 시 repository가 발급
                dto.title(),
                dto.tag(),
                dto.description(),
                dto.content(),
                user,
                LocalDateTime.now(),     // createdAt
                LocalDateTime.now()      // updatedAt
        );
    }

    @Override
    public PostDto toDto(PostEntity e) {
        return new PostDto(
                e.getId(),
                e.getTitle(),
                e.getTag(),
                e.getDescription(),
                e.getContent(),
                e.getUser().getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
