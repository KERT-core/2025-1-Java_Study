package com.javachip.study.mapper;

import com.javachip.study.domain.LectureEntity;
import com.javachip.study.dto.LectureGetDto;
import com.javachip.study.dto.LecturePostDto;

//LectureMapper 인터페이스의 구현체
//LecturePostDto -> LectureEntity -> LectureGetDto 변환 로직

public class LectureMapperImpl implements LectureMapper {
    @Override
    public LectureEntity toEntity(LecturePostDto dto, Long lectureId){
        return new LectureEntity(lectureId, dto.title(), dto.subtitle(), dto.date(), dto.location());
    }

    @Override
    public LectureGetDto toGetDto(LectureEntity entity) {
        return new LectureGetDto(entity.getLectureId(), entity.getTitle(), entity.getDate(), entity.getLocation(), null, null);
    }
}
