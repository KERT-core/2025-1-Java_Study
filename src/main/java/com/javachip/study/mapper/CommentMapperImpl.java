package com.javachip.study.mapper;

import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.CommentDto;
import com.javachip.study.domain.CommentEntity;
import com.javachip.study.domain.PostEntity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CommentMapperImpl implements CommentMapper {
    @Override
    public CommentEntity toEntity(CommentDto dto, PostEntity post, CommentEntity parent, UserEntity user) {
        return new CommentEntity(
                null,
                dto.content(),
                user.getId(),
                post,
                parent,
                LocalDateTime.now()
        );
    }
    @Override
    public CommentDto toDto(CommentEntity entity) {
        return new CommentDto(
                entity.getId(),
                entity.getUserId(),
                entity.getPostEntity().getId(),
                entity.getParent().getId(),
                entity.getContent(),
                entity.getCreateTime()
        );
    }
}
