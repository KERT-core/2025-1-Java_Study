package com.javachip.study.mapper;

import com.javachip.study.domain.PostEntity;
import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.CommentDto;
import com.javachip.study.domain.CommentEntity;
import com.javachip.study.dto.PostDto;

public interface CommentMapper {
    CommentEntity toEntity(CommentDto dto, PostEntity post, CommentEntity comment, UserEntity user);
    CommentDto toDto(CommentEntity entity);
}
