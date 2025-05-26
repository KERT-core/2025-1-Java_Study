// src/main/java/com/javachip/study/mapper/PostMapper.java
package com.javachip.study.mapper;

import com.javachip.study.domain.PostEntity;
import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.PostDto;

/**
 * Entity ↔ DTO 변환 전담
 */
public interface PostMapper {
    /** 새 글 저장용 **/
    PostEntity toEntity(PostDto dto, UserEntity user);
    /** 조회/응답용 **/
    PostDto    toDto(PostEntity entity);
}
